package com.be.bubble.user;

import com.be.bubble.admin.Admin;
import com.be.bubble.admin.AdminRepository;
import com.be.bubble.user.dto.LoginUserRequestDto;
import com.be.bubble.user.dto.SignUpUserRequestDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOneUser(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findOneUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public User signUpUser(SignUpUserRequestDTO signUpUserRequestDTO) {
        Admin admin = adminRepository.findById(1L).orElse(null);
        User user = User.builder()
                .email(signUpUserRequestDTO.getEmail())
                .password(bCryptPasswordEncoder.encode(signUpUserRequestDTO.getPassword()))
                .admin(admin)
                .build();

        userRepository.save(user);
        return user;
    }

    public User login(LoginUserRequestDto loginUserRequestDto) {
        User user = userRepository.findByEmail(loginUserRequestDto.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("Not Found User")
        );
        if (user != null) {
            bCryptPasswordEncoder.matches(loginUserRequestDto.getPassword(), user.getPassword());
        }
        return user;
    }
}
