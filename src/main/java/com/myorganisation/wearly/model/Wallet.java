package com.myorganisation.wearly.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wallet")
@Data
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Double balance = 0D;
}
