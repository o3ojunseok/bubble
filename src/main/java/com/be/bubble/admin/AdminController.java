package com.be.bubble.admin;

import com.be.bubble.admin.dto.AdminResponseDTO;
import com.be.bubble.admin.dto.SignUpAdminRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<Admin> signUpUser(@RequestBody SignUpAdminRequestDTO signUpUserRequestDTO) {
        Admin admin = adminService.signUpAdmin(signUpUserRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

    @GetMapping("/{id}")
    public AdminResponseDTO findOneAdmin(@PathVariable("id") Long id) {
        return adminService.findByAdmin(id);
    }
}
