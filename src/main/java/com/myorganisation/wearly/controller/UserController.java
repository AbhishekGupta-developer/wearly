package com.myorganisation.wearly.controller;

import com.myorganisation.wearly.dto.UserRequestDTO;
import com.myorganisation.wearly.dto.UserResponseDTO;
import com.myorganisation.wearly.service.UserService;
import com.myorganisation.wearly.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.registerUser(userRequestDTO), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.updateUser(id, userRequestDTO), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<String> removeUser(@RequestParam Long id) {
        return new ResponseEntity<>(userService.removeUser(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/email/{email}")
    public ResponseEntity<UserResponseDTO> searchByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.searchByEmail(email), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<UserResponseDTO>> searchByName(@PathVariable String name) {
        return new ResponseEntity<>(userService.searchByName(name), HttpStatusCode.valueOf(200));
    }

}
