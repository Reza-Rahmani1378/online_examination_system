package com.tosan.online_styem.rest;

import com.tosan.online_styem.base.web.rest.BaseRestFull;
import com.tosan.online_styem.models.User;
import com.tosan.online_styem.resource.mapper.UserMapper;
import com.tosan.online_styem.services.UserService;
import com.tosan.online_styem.services.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class HomeRestController extends BaseRestFull<User, UserDTO, Long, UserService, UserMapper> {


    public HomeRestController(UserService service, UserMapper mapper) {
        super(service, mapper);
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


}
