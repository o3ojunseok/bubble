package com.be.bubble.user;

import com.be.bubble.admin.Admin;
import com.be.bubble.admin.AdminRepository;
import com.be.bubble.user.dto.SignUpUserRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOneUser(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User signUpUser(SignUpUserRequestDTO signUpUserRequestDTO) {
        Admin admin = adminRepository.findById(1L).orElse(null);

        User user = User.builder()
                .email(signUpUserRequestDTO.getEmail())
                .password(signUpUserRequestDTO.getPassword())
                .admin(admin)
                .build();
        userRepository.save(user);
        return user;
    }
}
