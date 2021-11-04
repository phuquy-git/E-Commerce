package com.EcommerceBackEnd.EcommerceBackEnd.repository;

import com.EcommerceBackEnd.EcommerceBackEnd.model.ERole;
import com.EcommerceBackEnd.EcommerceBackEnd.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRname(ERole rname);
}
