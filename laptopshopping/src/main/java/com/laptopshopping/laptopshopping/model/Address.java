package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "addresses", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "province")
    @NotNull
    private String province;

    @Column(name = "ward")
    @NotNull
    private String ward;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
