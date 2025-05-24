package com.hotelbooking.user_service.service;

import com.hotelbooking.user_service.dto.UpdateProfileRequest;
import com.hotelbooking.user_service.model.User;
import com.hotelbooking.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> updateProfile(String email, UpdateProfileRequest dto) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        userOpt.ifPresent(user -> {
            user.setFullName(dto.getFullName());
            user.setPhone(dto.getPhone());
            user.setAddress(dto.getAddress());
            userRepository.save(user);
        });
        return userOpt;
    }
}
