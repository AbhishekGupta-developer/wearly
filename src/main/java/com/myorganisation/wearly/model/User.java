package com.myorganisation.wearly.model;

import com.myorganisation.wearly.model.enums.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Gender gender;
    private String email;
    private String phone;
    private String password;

}
