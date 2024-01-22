package com.be.bubble.user.dto;

import com.be.bubble.user.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class UserResponseDTO {
    private final Long id;
    private final String email;
    private final String password;
    private final Date loginAt;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.loginAt = user.getLoginAt();
    }
}
