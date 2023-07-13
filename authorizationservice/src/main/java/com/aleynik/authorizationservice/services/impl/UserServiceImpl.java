package com.aleynik.authorizationservice.services.impl;

import com.aleynik.authorizationservice.dto.request.RegistrationRequest;
import com.aleynik.authorizationservice.entity.User;
import com.aleynik.authorizationservice.exceptions.GetUserException;
import com.aleynik.authorizationservice.exceptions.RegistrationException;
import com.aleynik.authorizationservice.services.UserService;
import com.aleynik.authorizationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private RepositoryService repositoryService;


    public void registration(RegistrationRequest registrationRequest) {

        String patPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%!]).{8,}";
        if(!registrationRequest.getPassword().matches(patPassword))
            throw new RegistrationException("BAD PASSWORD");

        repositoryService.registration(registrationRequest);
    }

    public void generation(User user) {
        repositoryService.generation(user);
    }

    public User findByUsername(String username) {
        Optional<User> account = repositoryService.findByUsername(username);
        if (account.isEmpty()) throw new GetUserException("NOT FOUND USER");
        return account.get();
    }


    public List<User> get() {
        return repositoryService.getAllUsers();
    }
}
