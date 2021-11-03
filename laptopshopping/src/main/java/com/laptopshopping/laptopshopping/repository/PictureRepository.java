package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {
    Optional<Picture> findById(Integer id);
}
