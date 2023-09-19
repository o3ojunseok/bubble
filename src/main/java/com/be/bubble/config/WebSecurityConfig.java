package com.be.bubble.config;

import com.be.bubble.user.User;
import com.be.bubble.user.UserDetailServiceImpl;
import com.be.bubble.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        http.headers(AbstractHttpConfigurer::disable);
        http.logout(AbstractHttpConfigurer::disable);
        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        );
        http.authorizeHttpRequests(request -> request
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .requestMatchers("/user/authenticate").permitAll()
                .requestMatchers("/user/signup").permitAll()
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/favicon.ico").permitAll()
                .requestMatchers("/auth/**").permitAll()

                .anyRequest().authenticated()
        );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailServiceImpl userDetailService) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }
}
