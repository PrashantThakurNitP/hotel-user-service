package com.hotelbooking.user_service.dto;

import com.hotelbooking.user_service.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    private UserRole role = UserRole.USER;
}
