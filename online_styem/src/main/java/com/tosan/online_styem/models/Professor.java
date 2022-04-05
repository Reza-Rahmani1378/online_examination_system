package com.tosan.online_styem.models;

import com.tosan.online_styem.models.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Professor extends User{
    public static final String TABLE_NAME = "professor_table";



    public Professor(String firstName,
                     String lastName,
                     String username,
                     String password,
                     String nationalCode,
                     String email,
                     boolean isConfirmed) {
        super(firstName, lastName, username, password, nationalCode, email, UserType.PROFESSOR, isConfirmed);
    }
}
