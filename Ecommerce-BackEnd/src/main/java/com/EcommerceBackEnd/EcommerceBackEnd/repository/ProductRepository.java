package com.EcommerceBackEnd.EcommerceBackEnd.repository;

import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
