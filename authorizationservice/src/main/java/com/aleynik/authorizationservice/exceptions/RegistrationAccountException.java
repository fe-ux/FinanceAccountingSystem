package com.aleynik.authorizationservice.exceptions;

public class RegistrationAccountException extends RuntimeException{
    public RegistrationAccountException(String massage) {
        super(massage);
    }
}