package com.alamin.demo.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
}
