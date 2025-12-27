package com.ayur.service;

import com.ayur.dtos.*;
import com.ayur.entity.User;
import com.ayur.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public RegisterResponse register(RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            response.setSuccess(false);
            response.setMessage("Email already registered!");
            return response;
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword())); // 🔐 hashed password
        userRepository.save(user);

        response.setSuccess(true);
        response.setMessage("Registration successful!");
        return response;
    }

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (encoder.matches(request.getPassword(), user.getPassword())) {
                // Generate token
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                userRepository.save(user);

                response.setSuccess(true);
                response.setMessage("Login successful");
                response.setToken(token);
                return response;
            }
        }

        response.setSuccess(false);
        response.setMessage("Invalid email or password");
        return response;
    }
}

