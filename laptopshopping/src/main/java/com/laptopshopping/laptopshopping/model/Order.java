package com.laptopshopping.laptopshopping.model;

import com.laptopshopping.laptopshopping.model.enum_entity.PayingType;
import com.laptopshopping.laptopshopping.model.enum_entity.ShippingType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"order_id", "phone"})}, indexes = {
        @Index(name = "order_index", columnList = "order_id, order_date, shipping_fee")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    @NotNull
    private LocalDateTime orderDate;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "note")
    private String note;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column(name = "shipping_fee")
    @Min(value = 0)
    private Long shippingFee;

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

    @Enumerated(EnumType.STRING)
    private PayingType payingType;

    @Enumerated(EnumType.STRING)
    private ShippingType shippingType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
