package com.aleynik.authorizationservice.repository;

import com.aleynik.authorizationservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findByLogin(String login);

}
