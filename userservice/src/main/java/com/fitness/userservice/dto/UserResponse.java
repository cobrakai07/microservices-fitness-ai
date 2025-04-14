package com.fitness.userservice.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
