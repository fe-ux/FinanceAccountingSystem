package com.aleynik.authorizationservice.exceptions;

public class RegistrationException extends RuntimeException{
    public RegistrationException(String massage) {
        super(massage);
    }
}