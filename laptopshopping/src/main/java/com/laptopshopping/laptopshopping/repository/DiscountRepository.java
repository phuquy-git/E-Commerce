package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
