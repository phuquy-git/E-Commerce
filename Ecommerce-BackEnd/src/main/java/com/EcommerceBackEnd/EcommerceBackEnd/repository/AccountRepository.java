package com.EcommerceBackEnd.EcommerceBackEnd.repository;

import com.EcommerceBackEnd.EcommerceBackEnd.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<Account> findAccountByUsernameContainingIgnoreCase(String username);
}