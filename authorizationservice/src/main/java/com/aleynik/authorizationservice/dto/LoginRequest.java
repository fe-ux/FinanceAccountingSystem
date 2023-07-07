package com.aleynik.authorizationservice.dto;

import lombok.Data;

@Data
public class LoginRequest {
    String login;
    String password;
}
