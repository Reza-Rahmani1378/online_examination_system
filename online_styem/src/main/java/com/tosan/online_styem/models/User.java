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


    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    private String password;

    private String nationalCode;

    private String email;

    @Column()
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(columnDefinition = "TINYINT(1) default 0")
    private boolean isConfirmed;


    public User(String firstName,
                String lastName,
                String username,
                String password,
                String nationalCode,
                String email,
                boolean isConfirmed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.email = email;
        this.isConfirmed = isConfirmed;
    }

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
