package com.aleynik.authorizationservice.controller.handlers;

import com.aleynik.authorizationservice.exceptions.RegistrationAccountException;
import com.aleynik.authorizationservice.exceptions.DeleteAccountException;
import com.aleynik.authorizationservice.exceptions.ErrorResponse;
import com.aleynik.authorizationservice.exceptions.GetAllAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerExceptionHandlers {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DeleteAccountException.class)
    public ErrorResponse deleteException(DeleteAccountException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegistrationAccountException.class)
    public ErrorResponse addException(RegistrationAccountException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GetAllAccountException.class)
    public ErrorResponse getException(GetAllAccountException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
