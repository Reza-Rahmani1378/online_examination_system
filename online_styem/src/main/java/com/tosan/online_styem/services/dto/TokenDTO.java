package com.tosan.online_styem.services.dto;

import com.tosan.online_styem.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO extends BaseDTO<Integer> {

    private Integer id;

    private int userId;

    private String emailId;
}
