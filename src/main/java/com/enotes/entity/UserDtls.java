package com.enotes.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
public class UserDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "fullname", nullable = false)
    private String name;

//    @Column(name = "email", nullable = false)
    private String email;

//    @Column(name = "password", nullable = false)
    private String password;

    private String about;
    private String role;

    public UserDtls(){

    }
}
