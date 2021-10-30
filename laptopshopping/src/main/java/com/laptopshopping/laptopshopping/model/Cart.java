package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts", schema = "public",
        indexes = {
                @Index(name = "cart_index", columnList = "cart_id")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private  User user;

    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    private Order order;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItemList = new ArrayList<>();

    @Column(name = "valid")
    private boolean valid;

    public Cart(int cartId, User user, Order order) {
        this.cartId = cartId;
        this.user = user;
        this.order = order;
    }
}
