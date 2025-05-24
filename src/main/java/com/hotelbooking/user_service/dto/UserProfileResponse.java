package com.hotelbooking.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileResponse {
    private String email;
    private String fullName;
    private String phone;
    private String address;
}
