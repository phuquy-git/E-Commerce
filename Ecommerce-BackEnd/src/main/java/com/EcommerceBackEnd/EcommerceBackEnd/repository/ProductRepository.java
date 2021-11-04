package com.EcommerceBackEnd.EcommerceBackEnd.repository;

import com.EcommerceBackEnd.EcommerceBackEnd.model.Brand;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Category;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByOrderByProductIdAsc();
    List<Product> findAllByCategory(Category category);
    List<Product> findAllByBrand(Brand brand);
    List<Product> findByPnameContainingIgnoreCase(String name);
    List<Product> findByCategoryOrderByPriceAsc(Category category);
    List<Product> findByCategoryOrderByPriceDesc(Category category);
    List<Product> findByCategoryOrderByRatingDesc(Category category);
    List<Product> findByCategoryOrderByCreatedInDesc(Category category);
}
