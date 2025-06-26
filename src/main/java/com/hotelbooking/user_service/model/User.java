package com.hotelbooking.user_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "users") // since no sql
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private UUID id;

    @Indexed(unique = true)
    private String email;

    @JsonIgnore
    private String password; // Hashed
    // skip a field when serializing or deserializing

    private UserRole role;  // e.g., USER, HOTEL_OWNER, ADMIN

    private LocalDateTime createdAt;

    private String fullName;

    private String phone;

    private String address;

}