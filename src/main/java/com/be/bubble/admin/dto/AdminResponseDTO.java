package com.be.bubble.admin.dto;

import com.be.bubble.admin.Admin;
import com.be.bubble.user.User;
import com.be.bubble.user.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AdminResponseDTO {
    private final Long id;
    private final String email;
    private final String password;
    private final Date loginAt;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<UserResponseDTO> users;

    public AdminResponseDTO(Admin admin, List<User> user) {
        this.id = admin.getId();
        this.email = admin.getEmail();
        this.password = admin.getPassword();
        this.createdAt = admin.getCreatedAt();
        this.updatedAt = admin.getUpdatedAt();
        this.loginAt = admin.getLoginAt();
        this.users = user.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
        }
}
