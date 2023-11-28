package com.example.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.sql.Date;
@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long book_id;

    @NotBlank(message = "Title is required")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Author is required")
    @Column(name = "author")
    private String author;

    @NotBlank(message = "Genre is required")
    @Column(name = "genre")
    private String genre;

    @NotNull
    @Min(value = 1000, message = "Publication year must be greater than or equal to 1000")
    @Max(value = 9999, message = "Publication year must be less than or equal to 9999")
    @Digits(integer = 4, fraction = 0, message = "Invalid format for publication year")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Column(name = "publication_year")
    private Integer publication_year;


}
