package com.tosan.online_styem.rest;

import com.tosan.online_styem.base.web.rest.BaseRestFull;
import com.tosan.online_styem.models.User;
import com.tosan.online_styem.resource.mapper.UserMapper;
import com.tosan.online_styem.services.UserService;
import com.tosan.online_styem.services.dto.UserDTO;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserRestController extends BaseRestFull<User, UserDTO, Long, UserService, UserMapper> {


    public UserRestController(UserService service, UserMapper mapper) {
        super(service, mapper);
    }


}
