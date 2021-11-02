package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
