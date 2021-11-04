package com.EcommerceBackEnd.EcommerceBackEnd.repository;

import com.EcommerceBackEnd.EcommerceBackEnd.model.Account;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByProduct(Product product);
    List<Rating> findAllByAccount(Account account);
}
