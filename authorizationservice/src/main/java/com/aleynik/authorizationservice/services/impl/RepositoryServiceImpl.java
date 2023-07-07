package com.aleynik.authorizationservice.services.impl;

import com.aleynik.authorizationservice.entity.Account;
import com.aleynik.authorizationservice.entity.Role;
import com.aleynik.authorizationservice.exceptions.DeleteAccountException;
import com.aleynik.authorizationservice.exceptions.GetAllAccountException;
import com.aleynik.authorizationservice.exceptions.RegistrationAccountException;
import com.aleynik.authorizationservice.repository.AccountRepository;
import com.aleynik.authorizationservice.repository.RoleRepository;
import com.aleynik.authorizationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private AccountRepository accountRepository;
    private RoleRepository roleRepository;

    public Account Registration(Account request) {
        Role role = new Role("ROLE_ADMIN");
        request.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        request.addRole(role);
        try {
            accountRepository.save(request);
        }
        catch (Exception exception){
            throw new RegistrationAccountException("REGISTRATION ACCOUNT ETERNAL EXCEPTION = " + exception);
        }
        return request;
    }


    public void deleteAccount(UUID id) {
        try {
            accountRepository.deleteById(id);
        } catch (Exception exception) {
            throw new DeleteAccountException("DELETE ACCOUNT ETERNAL EXCEPTION = " + exception);
        }
    }

    public Optional<Account> findByLogin(String login) {
        Optional<Account> account;
        try {
            account = accountRepository.findByLogin(login);
        } catch (Exception exception) {
        throw new GetAllAccountException("GET ALL ACCOUNT ETERNAL EXCEPTION = " + exception);
        }
        return account;
    }

    public List<Account> getAllAccount() {
        try {
            return accountRepository.findAll();
        } catch (Exception exception) {
            throw new GetAllAccountException("GET ALL ACCOUNT ETERNAL EXCEPTION = " + exception);
        }
    }

}
