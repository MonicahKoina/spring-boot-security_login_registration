package com.registrationapp.demo.service;

import com.registrationapp.demo.entity.User;
import com.registrationapp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username is already taken.";
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email is already in use.";
        }
        userRepository.save(user);
        return "User registered successfully.";
    }
}
