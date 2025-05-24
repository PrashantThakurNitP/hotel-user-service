package com.hotelbooking.user_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    @JsonIgnore
    private String password; // Hashed
    private String role;
    private LocalDateTime createdAt;

    private String fullName;
    private String phone;
    private String address;
    /*
    The @JsonIgnore annotation is part of the Jackson library, which is used by Spring Boot to handle JSON serialization and deserialization.

🔍   What @JsonIgnore Does:
    @JsonIgnore tells Jackson to skip a field when serializing or deserializing an object to/from JSON.
     */
}