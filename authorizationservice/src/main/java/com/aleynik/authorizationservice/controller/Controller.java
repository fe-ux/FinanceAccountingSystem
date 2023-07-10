package com.aleynik.authorizationservice.controller;

import com.aleynik.authorizationservice.dto.request.LoginRequest;
import com.aleynik.authorizationservice.dto.request.RegistrationRequest;
import com.aleynik.authorizationservice.dto.response.JwtResponse;
import com.aleynik.authorizationservice.dto.response.MessageResponse;
import com.aleynik.authorizationservice.entity.User;
import com.aleynik.authorizationservice.security.jwt.JwtUtils;
import com.aleynik.authorizationservice.security.services.UserDetailsImpl;
import com.aleynik.authorizationservice.services.UserService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(("/auth"))
public class Controller {

    AuthenticationManager authenticationManager;

    JwtUtils jwtUtils;

    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationRequest registrationRequest) {
        userService.registration(registrationRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail()));
    }


    @GetMapping("/user")
    public ResponseEntity<User> getCurrietUser(@RequestHeader HttpHeaders headers) {
        String username = jwtUtils.getUserNameFromJwtToken(headers.get("Authorization").get(0).substring("Bearer ".length()));
        return ResponseEntity.ok(userService.findByUsername(username));
    }


    @GetMapping("/validate")
    public Boolean validate(@RequestParam String token) {
        return jwtUtils.validateJwtToken(token);
    }

    @KafkaListener(id = "AuthorizationService",topics = "generationaccounts")
    private void generationFinancialTransaction(String massage){
        Gson gson = new Gson();
        userService.generation(gson.fromJson(massage, User.class));
    }

}
