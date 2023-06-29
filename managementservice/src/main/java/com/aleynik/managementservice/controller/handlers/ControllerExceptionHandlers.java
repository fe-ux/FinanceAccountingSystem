package com.aleynik.managementservice.controller.handlers;

import com.aleynik.managementservice.exceptions.DeleteFinancialTransactionException;
import com.aleynik.managementservice.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerExceptionHandlers {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DeleteFinancialTransactionException.class)
    public ErrorResponse deleteException(DeleteFinancialTransactionException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
