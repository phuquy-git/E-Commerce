package com.laptopshopping.laptopshopping.repository;

import com.laptopshopping.laptopshopping.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public List<Account> findByUsernameAndUserPassword(String username, String user_password);
    public List<Account> findByUsername(String username);
}
