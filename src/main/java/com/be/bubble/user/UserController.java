package com.be.bubble.user;

import com.be.bubble.user.dto.SignUpUserRequestDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUpUser(@RequestBody SignUpUserRequestDTO signUpUserRequestDTO) {
        User user = userService.signUpUser(signUpUserRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/test")
    public Boolean userLogin(String email, HttpSession session) {
        session.setAttribute("hi", email);
        return true;
    }
}
