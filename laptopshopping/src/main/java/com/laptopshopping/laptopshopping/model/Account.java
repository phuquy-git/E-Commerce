package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "acounts", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username", "password"})},
        indexes = {
        @Index(name = "account_index", columnList = "account_id, username")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "username")
    @NotBlank
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "password_salt")
    @NotNull
    private String passwordSalt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "role_id")
    private Role role;

    public Account(int accountId, String username, String password, String passwordSalt, String firstName,
                   String lastName, String email, LocalDateTime lastLogin) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.lastLogin = lastLogin;
    }
}
