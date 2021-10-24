package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    @NotNull
    private Date orderDate;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "note")
    private String note;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column(name = "shipping_fee")
    @NotNull
    private BigDecimal shippingFee;

    @Column(name = "address_city")
    @NotNull
    private String addressCity;

    @Column(name = "address_province")
    @NotNull
    private String addressProvince;

    @Column(name = "address_ward")
    @NotNull
    private String addressWard;

    @Column(name = "address")
    @NotNull
    private String address;

    @ManyToOne
    @JoinColumn(name = "pay_via_id")
    private PayVia payVia;

    @ManyToOne
    @JoinColumn(name = "ship_via_id")
    private Shipping shipping;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
