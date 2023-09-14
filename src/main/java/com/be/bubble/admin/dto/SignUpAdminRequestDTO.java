package com.be.bubble.admin.dto;

import com.be.bubble.admin.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpAdminRequestDTO {

    private String email;
    private String password;
}
