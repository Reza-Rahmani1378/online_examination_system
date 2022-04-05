package com.tosan.online_styem.resource.mapper;

import com.tosan.online_styem.base.mapper.BaseMapper;
import com.tosan.online_styem.models.User;
import com.tosan.online_styem.services.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDTO> {

}
