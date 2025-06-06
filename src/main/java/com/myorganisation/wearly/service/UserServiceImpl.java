package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.UserRequestDTO;
import com.myorganisation.wearly.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO getUser(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        return null;
    }

    @Override
    public String removeUser(Long id) {
        return "";
    }
}
