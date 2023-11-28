package com.example.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank(message = "Username is required")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Email is required")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password hash is required")
    @Column(name = "password_hash")
    private String password_hash;


    @NotBlank(message = "Registration date hash is required")
    @Column(name = "registration_date")
    private Date registration_date;


}
