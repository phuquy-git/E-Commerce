package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    public List<Brand> findByBrandName(String brandName);
}
