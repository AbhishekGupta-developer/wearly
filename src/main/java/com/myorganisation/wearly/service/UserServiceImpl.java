package com.myorganisation.wearly.service;

import com.myorganisation.wearly.dto.request.UserRequestDTO;
import com.myorganisation.wearly.dto.response.UserResponseDTO;
import com.myorganisation.wearly.model.Cart;
import com.myorganisation.wearly.model.User;
import com.myorganisation.wearly.model.Wallet;
import com.myorganisation.wearly.repository.CartRepository;
import com.myorganisation.wearly.repository.UserRepository;
import com.myorganisation.wearly.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        Cart cart = new Cart();
        Wallet wallet = new Wallet();

        User user = mapUserRequestDTOToUser(userRequestDTO, new User());

        user.setCart(cart);
        cart.setUser(user);

        user.setWallet(wallet);
        wallet.setUser(user);

        userRepository.save(user);

        return mapUserToUserResponseDTO(user);
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
        userResponseDTO.setCart(user.getCart());

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        //Get all users from database (in User)
        List<User> userList = userRepository.findAll();

        //Create a list of UserResponseDTO
        List<UserResponseDTO> userResponseDTOList = new LinkedList<>();

        //traversal on a list of User
        for(User user : userList) {
            //conversion of User to UserResponseDTO
            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPhone(user.getPhone());
            userResponseDTO.setCart(user.getCart());

            //Inserting UserResponseDTO to list of UserResponseDTO
            userResponseDTOList.add(userResponseDTO);
        }

        return userResponseDTOList;
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElse(null);

        if(user == null) {
            System.out.println("User doesn't exist!");
        } else {
            user.setName(userRequestDTO.getName());
            user.setGender(userRequestDTO.getGender());
            user.setEmail(userRequestDTO.getEmail());
            user.setPhone(userRequestDTO.getPhone());
            user.setPassword(userRequestDTO.getPassword());

            userRepository.save(user);
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setCart(user.getCart());

        return userResponseDTO;
    }

    @Override
    public String removeUser(Long id) {
        String name = userRepository.findById(id).orElse(null).getName();
        userRepository.deleteById(id);
        return "User name: " + name + " (" + id + ") has been removed successfully!";
    }

    @Override
    public UserResponseDTO searchByEmail(String email) {
        User user = userRepository.findByEmail(email);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> searchByName(String name) {
        //Get all users from database (in User)
        List<User> userList = userRepository.findByNameContaining(name);

        //Create a list of UserResponseDTO
        List<UserResponseDTO> userResponseDTOList = new LinkedList<>();

        //traversal on a list of User
        for(User user : userList) {
            //conversion of User to UserResponseDTO
            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPhone(user.getPhone());

            //Inserting UserResponseDTO to list of UserResponseDTO
            userResponseDTOList.add(userResponseDTO);
        }

        return userResponseDTOList;
    }

    @Override
    public List<UserResponseDTO> customSearch(String q) {
        List<User> userList = userRepository.customSearch(q);
        List<UserResponseDTO> userResponseDTOList = new LinkedList<>();

        for(User user : userList) {
            //conversion of User to UserResponseDTO
            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPhone(user.getPhone());

            //Inserting UserResponseDTO to list of UserResponseDTO
            userResponseDTOList.add(userResponseDTO);
        }

        return userResponseDTOList;
    }

    @Override
    public Page<UserResponseDTO> getUsersPage(Integer page, Integer size, String sortBy, String orderBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                (orderBy.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending())
        );

        Page<User> userPage = userRepository.findAll(pageable);

        Page<UserResponseDTO> userResponseDTOPage = userPage.map(this::mapUserToUserResponseDTO);

        return userResponseDTOPage;
    }

    //Helper methods
    private User mapUserRequestDTOToUser(UserRequestDTO userRequestDTO, User user) {
        user.setName(userRequestDTO.getName());
        user.setGender(userRequestDTO.getGender());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setPassword(userRequestDTO.getPassword());

        return user;
    }

    private UserResponseDTO mapUserToUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setGender(user.getGender());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setCart(user.getCart());
        userResponseDTO.setWallet(user.getWallet());

        return userResponseDTO;
    }

}
