package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.UserRequestDTO;
import com.myorganisation.wearly.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUser(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    String removeUser(Long id);

    UserResponseDTO searchByEmail(String email);
    List<UserResponseDTO> searchByName(String name);

    List<UserResponseDTO> customSearch(String q);
}
