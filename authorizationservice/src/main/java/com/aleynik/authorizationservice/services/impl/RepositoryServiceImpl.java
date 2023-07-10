package com.aleynik.authorizationservice.services.impl;

import com.aleynik.authorizationservice.dto.request.RegistrationRequest;
import com.aleynik.authorizationservice.entity.User;
import com.aleynik.authorizationservice.exceptions.GetUserException;
import com.aleynik.authorizationservice.exceptions.RegistrationException;
import com.aleynik.authorizationservice.repository.UserRepository;
import com.aleynik.authorizationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private UserRepository userRepository;
    PasswordEncoder encoder;

    public void registration(RegistrationRequest registrationRequest) {
        if (userRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new RegistrationException("USERNAME ALREADY EXIST");
        }

        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new RegistrationException("EMAIL ALREADY EXIST");
        }

        User user = new User(registrationRequest.getFirstname(),registrationRequest.getLastname(),
                registrationRequest.getSurname(),registrationRequest.getUsername(),
                registrationRequest.getEmail(), encoder.encode(registrationRequest.getPassword()));

        try {
            userRepository.save(user);
        }
        catch (Exception exception){
            throw new RegistrationException("ETERNAL ERROR: " + exception);
        }
    }

    public void generation(User user) {
        try {
            userRepository.save(user);
        }
        catch (Exception exception){
            throw new RegistrationException("GENERATION ERROR: " + exception);
        }
    }

    public Optional<User> findByUsername(String username) {
        Optional<User> account;
        try {
            account = userRepository.findByUsername(username);
        } catch (Exception exception) {
        throw new GetUserException("GET USER BY USERNAME ETERNAL EXCEPTION = " + exception);
        }
        return account;
    }

    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception exception) {
            throw new GetUserException("GET ALL USERS ETERNAL EXCEPTION = " + exception);
        }
    }

}
