package com.aleynik.authorizationservice.services;

import com.aleynik.authorizationservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountService {

    User add(User request);

    User findByLogin(String login);

    void delete(UUID id);

    List<User> get();
}
