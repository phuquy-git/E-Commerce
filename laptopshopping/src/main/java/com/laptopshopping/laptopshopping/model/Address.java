package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses", schema = "public", indexes = {
        @Index(name = "address_index", columnList = "address_id")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "ward")
    private String ward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "defaultAddress", fetch = FetchType.LAZY)
    private User defaultAddressUser;

    public Address(int addressId, String city, String province, String ward) {
        this.addressId = addressId;
        this.city = city;
        this.province = province;
        this.ward = ward;
    }
}
