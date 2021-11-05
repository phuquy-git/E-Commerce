package com.EcommerceBackEnd.EcommerceBackEnd.repository;

import com.EcommerceBackEnd.EcommerceBackEnd.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
