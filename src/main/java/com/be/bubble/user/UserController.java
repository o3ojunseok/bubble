package com.be.bubble.user;

import com.be.bubble.user.dto.SignUpUserRequestDTO;
import lombok.RequiredArgsConstructor;
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
    public User signUpUser(@RequestBody SignUpUserRequestDTO signUpUserRequestDTO) {
        User user = userService.signUpUser(signUpUserRequestDTO);
        return user;
    }
}
