package com.be.bubble.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user =  userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Can't find" + email));
        return new UserDetailsImpl(user);
    }
}
