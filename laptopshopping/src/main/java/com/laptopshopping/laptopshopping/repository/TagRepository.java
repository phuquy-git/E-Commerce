package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    public List<Tag> findByTagName(String name);
}
