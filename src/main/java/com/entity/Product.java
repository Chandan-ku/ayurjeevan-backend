package com.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    @Column(columnDefinition = "TEXT")
    private String description;
    private double discount_percentage;
    private String imageUrl;
    @Column(columnDefinition = "TEXT")
    private String highlights;  // store as CSV or JSON string

    @Column(columnDefinition = "TEXT")
    private String policies;

}

