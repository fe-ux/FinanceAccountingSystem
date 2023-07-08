package com.aleynik.authorizationservice.repository;

import com.aleynik.authorizationservice.entity.ERole;
import com.aleynik.authorizationservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(ERole name);
}
