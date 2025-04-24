package com.example.testai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for User entity
 * Used to transfer data between client and server without exposing sensitive fields
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    
    // Password field is deliberately excluded for security
    // You may include it temporarily for registration/login DTOs

}
