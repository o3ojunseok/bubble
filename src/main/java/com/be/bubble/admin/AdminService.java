package com.be.bubble.admin;

import com.be.bubble.admin.dto.AdminResponseDTO;
import com.be.bubble.admin.dto.SignUpAdminRequestDTO;
import com.be.bubble.user.User;
import com.be.bubble.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public Admin signUpAdmin(SignUpAdminRequestDTO signUpRequestDto) {
        Admin admin = Admin.builder()
                .email(signUpRequestDto.getEmail())
                .password(bCryptPasswordEncoder.encode(signUpRequestDto.getPassword()))
                .build();
        adminRepository.save(admin);
        return admin;
    }

    public AdminResponseDTO findByAdmin(Long id) {
        Admin admin =  adminRepository.findById(id).orElse(null);
        return new AdminResponseDTO(admin, admin.getUser());
    }
}
