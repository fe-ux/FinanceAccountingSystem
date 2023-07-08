package com.aleynik.authorizationservice.services;

import com.aleynik.authorizationservice.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryService {

    User Registration(User request);

    void deleteAccount(UUID id);

    Optional<User> findByUsername(String login);

    List<User> getAllAccount();

}
