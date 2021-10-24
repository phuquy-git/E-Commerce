package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "discounts", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int discountId;

    @Column(name = "discount_price")
    @NotNull
    private BigDecimal discountPrice;

    @Column(name = "start_date")
    private float startDate;

    @Column(name = "end_date")
    private float endDate;

    @Column(name = "create_date")
    private float createDate;

    @Column(name = "update_date")
    private float updateDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product productId;
}
