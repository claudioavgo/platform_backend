package com.claudioav.eplataform.services;

import com.claudioav.eplataform.domain.user.User;
import com.claudioav.eplataform.dtos.UserDTO;
import com.claudioav.eplataform.exceptions.UserNotFoundException;
import com.claudioav.eplataform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.email()) != null) {
            throw new RuntimeException("This email already exists");
        } else {
            User user = new User(userDTO);
            user.setPassword(passwordEncoder.encode(userDTO.password()));
            userRepository.save(user);
            return user;
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateUserById(String id, UserDTO data) {
        User user = getUserById(id);
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPhone(data.phone());
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(String id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
