package com.tosan.online_styem.models;

import com.tosan.online_styem.base.BaseEntity;
import com.tosan.online_styem.models.enumeration.UserType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity<Long> {
    public static final String TABLE_NAME = "user_table";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String NATIONAL_CODE = "national_code";
    private static final String USER_TYPE = "user_type";


    @Column(name = User.FIRST_NAME)
    private String firstName;
    @Column(name = User.LAST_NAME)
    private String lastName;

    @Column(unique = true)
    private String username;

    private String password;
    @Column(name = User.NATIONAL_CODE)
    private String nationalCode;

    private String email;

    @Column(name = User.USER_TYPE)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(columnDefinition = "TINYINT(1) default 0")
    private boolean isConfirmed;




    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", userType=" + userType +
                ", email='" + email + '\'' +
                ", isConfirmed=" + isConfirmed +
                '}';
    }


}
