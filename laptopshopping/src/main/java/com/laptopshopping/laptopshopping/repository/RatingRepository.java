package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
