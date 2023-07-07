package com.aleynik.authorizationservice.services;

import com.aleynik.authorizationservice.entity.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryService {

    Account Registration(Account request);

    void deleteAccount(UUID id);

    Optional<Account> findByLogin(String login);

    List<Account> getAllAccount();

}
