package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.request.UserRequestDTO;
import com.myorganisation.wearly.dto.response.UserResponseDTO;
import org.springframework.data.domain.Page;

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

    Page<UserResponseDTO> getUsersPage(Integer page, Integer size, String sortBy, String orderBy);
}
