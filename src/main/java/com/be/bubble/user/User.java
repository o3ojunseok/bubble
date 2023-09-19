package com.be.bubble.user;

import com.be.bubble.admin.Admin;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Date loginAt;

    @ManyToOne
    @JoinColumn(name = "adminId", nullable = true)
    @JsonIgnore
    private Admin admin;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    @Builder
    public User(String email, String password, Date loginAt, Admin admin) {
        this.email = email;
        this.password = password;
        this.loginAt = loginAt;
        this.admin = admin;
    }
}
