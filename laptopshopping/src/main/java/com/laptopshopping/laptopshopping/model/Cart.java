package com.laptopshopping.laptopshopping.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "carts", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private  User user;

    @Column(name = "valid")
    private boolean valid;

    @OneToMany(mappedBy = "cart")
    Set<CartItem> quantity;
}
