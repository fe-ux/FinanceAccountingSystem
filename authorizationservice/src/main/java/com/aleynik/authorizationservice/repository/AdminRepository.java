package com.aleynik.authorizationservice.repository;

import com.aleynik.authorizationservice.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
