package com.myorganisation.wearly.dto.response;

import com.myorganisation.wearly.model.Cart;
import com.myorganisation.wearly.model.Wallet;
import com.myorganisation.wearly.model.enums.Gender;
import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private Gender gender;
    private String email;
    private String phone;
    private Cart cart;
    private Wallet wallet;
}
