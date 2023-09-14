package com.be.bubble.user;

import com.be.bubble.admin.Admin;
import com.be.bubble.common.DateTime;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends DateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Date loginAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminId",nullable = true)
    private Admin admin;

    @Builder
    public User(String email, String password, Date loginAt, Admin admin) {
        this.email = email;
        this.password = password;
        this.loginAt = loginAt;
        this.admin = admin;
    }
}
