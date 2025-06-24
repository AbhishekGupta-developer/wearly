package com.myorganisation.wearly.model;

import com.myorganisation.wearly.model.enums.Category;
import jakarta.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Category category;
    private String name;
    private String brand;
    private Double amount;

}
