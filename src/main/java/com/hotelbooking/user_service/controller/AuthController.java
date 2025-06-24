package com.hotelbooking.user_service.controller;

import com.hotelbooking.user_service.dto.AuthResponse;
import com.hotelbooking.user_service.dto.LoginRequest;
import com.hotelbooking.user_service.dto.RegisterRequest;
import com.hotelbooking.user_service.security.JwtTokenProvider;
import com.hotelbooking.user_service.service.AuthService;
import com.hotelbooking.user_service.service.TokenBlacklistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Authentication and Logout APIs")
public class AuthController {

    private final AuthService authService;
    private final TokenBlacklistService blacklistService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    @Operation(
            summary = "Register a new user",
            description = "Creates a new user account with email, password, and other registration info"
    )
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    @Operation(
            summary = "User login",
            description = "Authenticates user with email and password and returns a JWT token"
    )
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Operation(
            summary = "User logout",
            description = "Invalidates JWT token by blacklisting it using its JTI (JWT ID)"
    )
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String jti = jwtTokenProvider.extractJti(token);
        long expirationTime = jwtTokenProvider.extractAllClaims(token).getExpiration().getTime() - System.currentTimeMillis();
        blacklistService.blacklistToken(jti, expirationTime);

        return ResponseEntity.ok("Logged out successfully.");
    }
}
