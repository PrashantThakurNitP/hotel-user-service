package com.hotelbooking.user_service.service;

import com.hotelbooking.user_service.dto.AuthResponse;
import com.hotelbooking.user_service.dto.LoginRequest;
import com.hotelbooking.user_service.dto.RegisterRequest;
import com.hotelbooking.user_service.model.User;
import com.hotelbooking.user_service.repository.UserRepository;
import com.hotelbooking.user_service.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtProvider;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        User user = User.builder()
                .id(UUID.randomUUID())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .build();
        userRepository.save(user);
        return new AuthResponse(jwtProvider.generateToken(user));
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return new AuthResponse(jwtProvider.generateToken(user));
    }
}