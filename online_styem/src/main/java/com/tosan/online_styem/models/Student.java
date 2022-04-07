package com.tosan.online_styem.models;

import com.tosan.online_styem.models.enumeration.UserType;
import lombok.Builder;
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
@Builder
public class Student extends User {
    public static final String TABLE_NAME = "student_table";


    public Student(String firstName,
                   String lastName,
                   String username,
                   String password,
                   String nationalCode,
                   String email
    ) {
        super(firstName, lastName, username, password, nationalCode, email, UserType.STUDENT, false);
    }
}
