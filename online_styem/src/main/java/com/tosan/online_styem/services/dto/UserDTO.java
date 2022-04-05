package com.tosan.online_styem.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import com.tosan.online_styem.base.BaseDTO;
import com.tosan.online_styem.models.enumeration.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class UserDTO extends BaseDTO<Long> {
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    @JsonProperty("username")
    private String username;

    @JsonProperty("nationalCode")
    private String nationalCode;


    @NotNull
    @JsonProperty("password")
    private String password;

    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("userType")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    private boolean isConfirmed;
}
