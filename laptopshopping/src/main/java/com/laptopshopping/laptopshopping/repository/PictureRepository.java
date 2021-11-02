package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
