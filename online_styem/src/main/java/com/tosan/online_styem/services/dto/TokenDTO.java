package com.tosan.online_styem.services.dto;

import com.tosan.online_styem.base.BaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenDTO extends BaseDTO<Integer> {

    private Integer id;

    private Long userId;

    private String emailId;
}
