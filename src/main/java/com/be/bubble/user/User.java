package com.be.bubble.user;

<<<<<<< HEAD
import com.be.bubble.admin.Admin;
=======
>>>>>>> 8cfc58a4b1c23dfe99bb14ec8652ec7b7ed7fc2d
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
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

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin admin;

=======
>>>>>>> 8cfc58a4b1c23dfe99bb14ec8652ec7b7ed7fc2d
    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    @Builder
    public User(String email, String password, Date loginAt) {
        this.email = email;
        this.password = password;
        this.loginAt = loginAt;
    }
}
