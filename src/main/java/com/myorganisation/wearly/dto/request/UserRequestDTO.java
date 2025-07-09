package com.myorganisation.wearly.dto.request;

import com.myorganisation.wearly.model.enums.Gender;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String name;
    private Gender gender;
    private String email;
    private String phone;
    private String password;
}
