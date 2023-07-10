package com.aleynik.authorizationservice.exceptions;

public class GetUserException extends RuntimeException {

    public GetUserException(String massage) {
        super(massage);
    }
}
