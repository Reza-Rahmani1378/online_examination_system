package com.tosan.online_styem.resource.mapper;

import com.tosan.online_styem.base.mapper.BaseMapper;
import com.tosan.online_styem.models.Token;
import com.tosan.online_styem.services.dto.TokenDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TokenMapper extends BaseMapper<Token, TokenDTO> {
}
