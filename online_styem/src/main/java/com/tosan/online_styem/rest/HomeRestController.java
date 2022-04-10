package com.tosan.online_styem.rest;

import com.tosan.online_styem.base.web.rest.BaseRestFull;
import com.tosan.online_styem.exception.NotExistUserEntity;
import com.tosan.online_styem.models.Professor;
import com.tosan.online_styem.models.Student;
import com.tosan.online_styem.models.User;
import com.tosan.online_styem.resource.mapper.UserMapper;
import com.tosan.online_styem.services.ProfessorService;
import com.tosan.online_styem.services.StudentService;
import com.tosan.online_styem.services.TokenService;
import com.tosan.online_styem.services.UserService;
import com.tosan.online_styem.services.dto.TokenDTO;
import com.tosan.online_styem.services.dto.UserDTO;
import com.tosan.online_styem.util.GenerateToken;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class HomeRestController extends BaseRestFull<User, UserDTO, Long, UserService, UserMapper> {

    private final UserService userService;
    private final UserMapper userMapper;
    private final StudentService studentService;
    private final ProfessorService professorService;
    private final TokenService tokenService;
    private final GenerateToken generateToken;


    public HomeRestController(UserService service,
                              UserMapper mapper,
                              StudentService studentService,
                              ProfessorService professorService,
                              TokenService tokenService,
                              GenerateToken generateToken
    ) {
        super(service, mapper);
        this.userService = service;
        this.userMapper = mapper;
        this.studentService = studentService;
        this.professorService = professorService;
        this.tokenService = tokenService;
        this.generateToken = generateToken;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserDTO>> getAll() {
        return super.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        return super.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        return super.findById(id);
    }

    @PostMapping("/add")
    @Override
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        return super.save(userDTO);
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        return super.update(userDTO);
    }

    /*  @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        return getAll();
    }*/



    @PostMapping("/saveUser")
    public int saveUser(@RequestBody UserDTO userDTO) {

        if (userDTO.getUserType().name().equals("STUDENT")) {
            Student newStudent = new Student(
                    userDTO.getFirstName(),
                    userDTO.getLastName(),
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getNationalCode(),
                    userDTO.getEmail()
            );
            studentService.saveNotSecure(newStudent);
            return 1;
        } else {
            Professor newProfessor = new Professor(
                    userDTO.getFirstName(),
                    userDTO.getLastName(),
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getNationalCode(),
                    userDTO.getEmail()

            );
            professorService.saveNotSecure(newProfessor);

            return 2;
        }


    }

    @PostMapping(value = "/login" /*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        Long status = 0L;
        HttpHeaders httpHeader = null;
        // get userType  by email
//        String userType = null;


        userDTO =
                userMapper.convertEntityToDTO(userService.login(userDTO.getPassword(), userDTO.getEmail()));
        if (userDTO != null) {
//            userType =userService.getUserTypeByEmail(userDTO.getEmail());

            /*switch (userType) {
                case "ADMIN" :
                    = 1L;
                case "PROFESSOR" :
                    = 2L;
                case "STUDENT" :
                    = 3L;
            }*/
            status = userDTO.getId();
        } else {
            throw new NotExistUserEntity("This User is not Signup.");
        }
        if (status > 0) {

            String[] tokenData = generateToken.createJWT(
                    userDTO.getEmail(),
                    "Java",
                    "JWT token",
                    userDTO.getUserType().name(),
                    1800000

            );

            // get Token
            String token = tokenData[0];
            // create The header objects
            httpHeader = new HttpHeaders();
            httpHeader.add("Authorization", token);

            // check if token is already exist
            long isUserEmailExist = tokenService.getTokenDetail(userDTO.getEmail());

            /*
             * If token exist then update Token else create and insert the token.
             */
            if (isUserEmailExist <= 0) {
                TokenDTO tokenDTO = TokenDTO.builder()
                        .emailId(userDTO.getEmail())
                        .userId(userDTO.getId())
                        .build();
                // save user email in token table
                tokenService.saveUserEmail(tokenDTO);

            }
            tokenService.updateToken(userDTO.getEmail(), token, tokenData[1]);


            return new ResponseEntity<>(userDTO, httpHeader, HttpStatus.OK);

        }
        userDTO.setId(-1L);
        return new ResponseEntity<>(userDTO, null, HttpStatus.OK);
    }

}
