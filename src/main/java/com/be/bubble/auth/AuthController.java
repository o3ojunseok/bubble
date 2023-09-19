package com.be.bubble.auth;

import com.be.bubble.admin.AdminService;
import com.be.bubble.user.User;
import com.be.bubble.user.UserService;
import com.be.bubble.user.dto.LoginUserRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AdminService adminService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginUserRequestDto loginUserRequestDto, HttpSession session) {
        User user = userService.login(loginUserRequestDto);
        session.setAttribute("LoginUser", user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/check")
    public Optional<User> check(HttpServletRequest request, HttpSession session) {
        String attr = session.getAttribute("LoginUser").toString();
        return userService.findOneUserEmail(attr);
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "logout success";
    }
}
