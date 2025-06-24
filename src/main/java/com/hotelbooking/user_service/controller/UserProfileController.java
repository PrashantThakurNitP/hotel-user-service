package com.hotelbooking.user_service.controller;

import com.hotelbooking.user_service.dto.UpdateProfileRequest;
import com.hotelbooking.user_service.model.User;
import com.hotelbooking.user_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@Tag(name = "User", description = "User Profile APIs")
public class UserProfileController {

    private final UserService userService;
    //@AuthenticationPrincipal tells Spring to inject the authenticated UserDetails object from the security context into the method.
    @GetMapping
    @Operation(summary = "Get User Profile", description = "Returns logged user user profile")
    public ResponseEntity<?> getProfile(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Operation(summary = "Update User Profile", description = "Update logged user user profile")
    public ResponseEntity<?> updateProfile(@AuthenticationPrincipal UserDetails userDetails,
                                           @RequestBody UpdateProfileRequest dto) {
        String email = userDetails.getUsername();
        Optional<User> updatedUser = userService.updateProfile(email, dto);
        return updatedUser.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
