package com.be.bubble.admin;

import com.be.bubble.admin.dto.AdminResponseDTO;
import com.be.bubble.admin.dto.SignUpAdminRequestDTO;
import com.be.bubble.user.User;
import com.be.bubble.user.dto.SignUpUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admin/signup")
    public ResponseEntity<Admin> signUpUser(@RequestBody SignUpAdminRequestDTO signUpUserRequestDTO) {
        Admin admin = adminService.signUpAdmin(signUpUserRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> findOneAdmin(@PathVariable("id") Long id) {
        AdminResponseDTO admin = adminService.findByAdmin(id);
        return ResponseEntity.status(HttpStatus.OK).body(admin);
    }
}
