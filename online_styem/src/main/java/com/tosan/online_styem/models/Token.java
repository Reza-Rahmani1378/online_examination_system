package com.tosan.online_styem.models;

import com.tosan.online_styem.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Token.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Token extends BaseEntity<Integer> {
    public static final String TABLE_NAME = "token_table";
    private static final String USER_ID = "user_id";
    private static final String AUTHENTICATION_TOKEN = "authentication_token";
    private static final String SECRET_KEY = "secret_key";
    private static final String EMAIL_ID = "email_id";


    @Column(name = Token.USER_ID)
    private int userId;

    @Column(name = Token.AUTHENTICATION_TOKEN)
    private String authenticationToken;

    @Column(name = Token.SECRET_KEY)
    private String secretKey;

    @Column(name = Token.EMAIL_ID)
    private String emailId;


}
