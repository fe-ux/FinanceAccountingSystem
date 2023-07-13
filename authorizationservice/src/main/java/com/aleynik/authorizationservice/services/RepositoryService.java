package com.aleynik.authorizationservice.services;

import com.aleynik.authorizationservice.dto.request.RegistrationRequest;
import com.aleynik.authorizationservice.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryService {

    void registration(RegistrationRequest registrationRequest);

    void generation(User user);


    Optional<User> findByUsername(String username);

    List<User> getAllUsers();

}
