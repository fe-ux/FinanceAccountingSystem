package com.aleynik.authorizationservice.controller.handlers;

import com.aleynik.authorizationservice.exceptions.RegistrationException;
import com.aleynik.authorizationservice.exceptions.ErrorResponse;
import com.aleynik.authorizationservice.exceptions.GetUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerExceptionHandlers {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegistrationException.class)
    public ErrorResponse addException(RegistrationException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GetUserException.class)
    public ErrorResponse getException(GetUserException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
