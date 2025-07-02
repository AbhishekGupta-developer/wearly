package com.myorganisation.wearly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount = 0D;

    @OneToOne(mappedBy = "cart")
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;


}
