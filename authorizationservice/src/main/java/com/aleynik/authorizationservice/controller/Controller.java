package com.aleynik.authorizationservice.controller;

import com.aleynik.authorizationservice.dto.LoginResponse;
import com.aleynik.authorizationservice.dto.LoginRequest;
import com.aleynik.authorizationservice.entity.Account;
import com.aleynik.authorizationservice.jwt.JwtTokenUtil;
import com.aleynik.authorizationservice.services.AccountService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.UUID;


@RestController
@AllArgsConstructor
public class Controller {

    private AuthenticationManager authManager;

    private JwtTokenUtil jwtUtil;

    private AccountService accountService;

    @PostMapping("/registration")
    public ResponseEntity<Account> registration(@RequestBody Account request) {
        accountService.add(request);
        return ResponseEntity.ok(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getLogin(), loginRequest.getPassword())
            );

            Account account = (Account) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            LoginResponse response = new LoginResponse(account.getLogin(), accessToken);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            System.out.println(ex.toString());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/manage_accounts")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<Void> deleteAccount(@RequestParam UUID id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/manage_accounts")
    @RolesAllowed({"ROLE_ADMIN"})
    public ResponseEntity<List<Account>> getAll() {
       return ResponseEntity.ok(accountService.get());
    }

    @KafkaListener(id = "AuthorizationService",topics = "generationaccounts")
    private void generationFinancialTransaction(String massage){
        Gson gson = new Gson();
        accountService.add(gson.fromJson(massage,Account.class));
    }

}
