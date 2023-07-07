package com.aleynik.authorizationservice.services;

import com.aleynik.authorizationservice.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface AccountService {

    Account add(Account request);

    Account findByLogin(String login);

    void delete(UUID id);

    List<Account> get();
}
