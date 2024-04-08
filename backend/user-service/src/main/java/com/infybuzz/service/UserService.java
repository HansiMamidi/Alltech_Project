package com.infybuzz.service;

import com.infybuzz.entity.User;
import com.infybuzz.repository.UserRepository;
import com.infybuzz.request.CreateUserRequest;
import com.infybuzz.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());
        user.setEmail(createUserRequest.getEmail());
        user.setUserType(createUserRequest.getUserType());

        User savedUser = userRepository.save(user);

        return new UserResponse(savedUser);
    }

    public UserResponse getUserById(Long id) {
        logger.info("Inside getUserById " + id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return new UserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        logger.info("Inside getAllUsers");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public UserResponse updateUser(Long id, CreateUserRequest updateUserRequest) {
        logger.info("Inside updateUser " + id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (updateUserRequest.getUsername() != null) {
            user.setUsername(updateUserRequest.getUsername());
        }

        if (updateUserRequest.getPassword() != null) {
            user.setPassword(updateUserRequest.getPassword());
        }

        if (updateUserRequest.getEmail() != null) {
            user.setEmail(updateUserRequest.getEmail());
        }

        if (updateUserRequest.getUserType() != null) {
            user.setUserType(updateUserRequest.getUserType());
        }

        User updatedUser = userRepository.save(user);

        return new UserResponse(updatedUser);
    }

    public void deleteUserById(Long id) {
        logger.info("Inside deleteUserById " + id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
