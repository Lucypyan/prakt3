package com.example.demo.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(name = "product_name")
    private String productName;

    @NotBlank(message = "Price is required")
    @Column(name = "price")
    private double price;


    @NotBlank(message = "Stock quanity is required")
    @Column(name = "stock_quantity")
    private int stockQuantity;

    @NotBlank(message = "Manufacturer is required")
    @Column(name = "manufacturer")
    private String manufacturer;


}
