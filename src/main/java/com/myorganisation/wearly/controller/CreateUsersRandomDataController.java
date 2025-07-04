package com.myorganisation.wearly.controller;

import com.myorganisation.wearly.dto.UserRequestDTO;
import com.myorganisation.wearly.model.enums.Gender;
import com.myorganisation.wearly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CreateUsersRandomData")
public class CreateUsersRandomDataController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUsersRandomData() {

        for(int i=100; i<100001; i++) {
            int randomId = i + 3;
            String name = "Test " + randomId + " Postman";
            Gender gender = Gender.NOT_DISCLOSED;
            String email = "test" + randomId + ".postman@wearly.com";
            String phone = "1234567890";
            String password = "root@" + randomId;

            UserRequestDTO userRequestDTO = new UserRequestDTO();
            userRequestDTO.setName(name);
            userRequestDTO.setGender(gender);
            userRequestDTO.setEmail(email);
            userRequestDTO.setPhone(phone);
            userRequestDTO.setPassword(password);

            userService.registerUser(userRequestDTO);
        }

        return new ResponseEntity<>("Random users added successfully!", HttpStatus.OK);
    }
}
