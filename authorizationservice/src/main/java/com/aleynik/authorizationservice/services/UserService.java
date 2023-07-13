package com.aleynik.authorizationservice.services;

import com.aleynik.authorizationservice.dto.request.RegistrationRequest;
import com.aleynik.authorizationservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    void registration(RegistrationRequest registrationRequest);

    void generation(User user);

    User findByUsername(String username);


    List<User> get();
}
