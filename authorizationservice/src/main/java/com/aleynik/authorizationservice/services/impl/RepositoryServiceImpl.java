package com.aleynik.authorizationservice.services.impl;

import com.aleynik.authorizationservice.entity.User;
import com.aleynik.authorizationservice.exceptions.DeleteAccountException;
import com.aleynik.authorizationservice.exceptions.GetAllAccountException;
import com.aleynik.authorizationservice.repository.UserRepository;
import com.aleynik.authorizationservice.repository.RoleRepository;
import com.aleynik.authorizationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public User Registration(User request) {
        return request;
    }


    public void deleteAccount(UUID id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception exception) {
            throw new DeleteAccountException("DELETE ACCOUNT ETERNAL EXCEPTION = " + exception);
        }
    }

    public Optional<User> findByUsername(String username) {
        Optional<User> account;
        try {
            account = userRepository.findByUsername(username);
        } catch (Exception exception) {
        throw new GetAllAccountException("GET ALL ACCOUNT ETERNAL EXCEPTION = " + exception);
        }
        return account;
    }

    public List<User> getAllAccount() {
        try {
            return userRepository.findAll();
        } catch (Exception exception) {
            throw new GetAllAccountException("GET ALL ACCOUNT ETERNAL EXCEPTION = " + exception);
        }
    }

}
