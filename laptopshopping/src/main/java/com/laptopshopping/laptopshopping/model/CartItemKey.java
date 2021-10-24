package com.laptopshopping.laptopshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemKey implements Serializable {

    @Column(name = "product_id")
    private int productId;

    @Column(name = "cart_id")
    private int cartId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItemKey)) return false;
        CartItemKey CartItemKey = (CartItemKey) o;
        return getProductId() == CartItemKey.getProductId() && getCartId() == CartItemKey.getCartId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getCartId());
    }
}
