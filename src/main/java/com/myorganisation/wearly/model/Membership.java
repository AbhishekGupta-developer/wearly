package com.myorganisation.wearly.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "membership")
@Data
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String duration;

    @ElementCollection
    @CollectionTable(name = "membership_benefits", joinColumns = @JoinColumn(name = "membership_id"))
    @Column(name = "benefit")
    private List<String> benefits;
}
