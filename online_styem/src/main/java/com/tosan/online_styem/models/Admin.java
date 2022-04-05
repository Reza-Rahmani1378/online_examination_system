package com.tosan.online_styem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Admin.TABLE_NAME)
@NoArgsConstructor
@Getter
@Setter
public class Admin extends User {

    public static final String TABLE_NAME = "admin_table";
}
