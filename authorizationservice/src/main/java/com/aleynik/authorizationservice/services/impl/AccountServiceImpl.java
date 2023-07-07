package com.aleynik.authorizationservice.services.impl;

import com.aleynik.authorizationservice.entity.Account;
import com.aleynik.authorizationservice.exceptions.RegistrationAccountException;
import com.aleynik.authorizationservice.services.AccountService;
import com.aleynik.authorizationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private RepositoryService repositoryService;

    public Account add(Account request) {
        String patPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%!]).{8,}";
        String patMail = "(?=.*[@.]).{4,}";
        if(!request.getPassword().matches(patPassword)
                || !request.getMail().matches(patMail)
        ) throw new RegistrationAccountException("BAD REGISTRATION REQUEST = "+request);
        return repositoryService.Registration(request);
    }


    public Account findByLogin(String login) {
        Optional<Account> account = repositoryService.findByLogin(login);
        if (account.isEmpty()) throw new RuntimeException();
        return account.get();
    }

    public void delete(UUID id) {
        repositoryService.deleteAccount(id);
    }

    public List<Account> get() {
        return repositoryService.getAllAccount();
    }
}
