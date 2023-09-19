package com.be.bubble.admin;

import com.be.bubble.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Date loginAt;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> user = new ArrayList<>();

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    @Builder
    public Admin(String email, String password, Date loginAt, List<User> user) {
        this.email = email;
        this.password = password;
        this.loginAt = loginAt;
        this.user = user;
    }
}
