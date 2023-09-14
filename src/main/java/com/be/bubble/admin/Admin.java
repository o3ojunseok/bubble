package com.be.bubble.admin;

import com.be.bubble.common.DateTime;
import com.be.bubble.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends DateTime {

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
    private List<User> user = new ArrayList<>();

    @Builder
    public Admin(String email, String password, Date loginAt, List<User> user) {
        this.email = email;
        this.password = password;
        this.loginAt = loginAt;
        this.user = user;
    }
}
