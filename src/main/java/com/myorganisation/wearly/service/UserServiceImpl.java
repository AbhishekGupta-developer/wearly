package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.UserRequestDTO;
import com.myorganisation.wearly.dto.UserResponseDTO;
import com.myorganisation.wearly.model.User;
import com.myorganisation.wearly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setGender(userRequestDTO.getGender());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setPassword(userRequestDTO.getPassword());

        userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return null;
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
