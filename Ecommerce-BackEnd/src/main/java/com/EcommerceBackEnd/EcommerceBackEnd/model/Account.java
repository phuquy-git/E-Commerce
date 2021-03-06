package com.EcommerceBackEnd.EcommerceBackEnd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }, indexes = {@Index(name = "account_index", columnList = "account_id, username", unique = true)})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", unique = true)
    private long accountId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Size(min = 3, max = 20)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    @Email
    private String email;

    @Size(min = 10, max = 12)
    @Column(name = "phone")
    private String phone;

    @Column(name = "created_in")
    private LocalDateTime createdIn;

    @Column(name = "updated_in")
    private LocalDateTime updatedIn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
