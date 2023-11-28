package com.example.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;
@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employee_id;

    @NotBlank(message = "Firstname is required")
    @Column(name = "first_name")
    private String first_name;

    @NotBlank(message = "Lastname is required")
    @Column(name = "last_name")
    private String last_name;

    @NotBlank(message = "Position is required")
    @Column(name = "position")
    private String position;

    @NotBlank(message = "HireDate is required")
    @Column(name = "hire_date")
    private Date hire_date;


}
