package com.laptopshopping.laptopshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {

    @EmbeddedId
    CartItemKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    Cart cart;

    int quantity;

}
