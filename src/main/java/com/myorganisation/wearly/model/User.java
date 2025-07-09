package com.myorganisation.wearly.model;

import com.myorganisation.wearly.model.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;
    private String phone;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart")
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet")
    private Wallet wallet;
}
