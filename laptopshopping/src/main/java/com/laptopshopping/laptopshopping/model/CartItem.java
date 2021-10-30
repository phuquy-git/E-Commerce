package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "cart_items", schema = "public", indexes = {
        @Index(name = "cart_item_index", columnList = "quantity")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_items")
    private int cartItemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "cart_id")
    Cart cart;

    @Column(name = "quantity")
    @Min(value = 0)
    private int quantity;

    public CartItem(int cartItemId, Cart cart, int quantity) {
        this.cartItemId = cartItemId;
        this.cart = cart;
        this.quantity = quantity;
    }
}
