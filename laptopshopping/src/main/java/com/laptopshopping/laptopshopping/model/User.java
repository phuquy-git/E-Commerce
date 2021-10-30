package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"phone_number"})},
        indexes = {
                @Index(name = "phone_number_index", columnList = "phone_number")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private Account account;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "default_address")
    private Address defaultAddress;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratingList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart> cartList = new ArrayList<>();

    public User(int userId, String phoneNumber, LocalDateTime registerDate, Account account, Address defaultAddress,
                List<Address> addressList, List<Rating> ratingList, List<Cart> cartList) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;
        this.account = account;
        this.defaultAddress = defaultAddress;
        this.addressList = addressList;
        this.ratingList = ratingList;
        this.cartList = cartList;
    }
}
