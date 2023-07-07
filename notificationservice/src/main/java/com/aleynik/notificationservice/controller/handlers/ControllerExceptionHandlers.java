package com.aleynik.notificationservice.controller.handlers;

import com.aleynik.notificationservice.exceptions.AddFinancialTransactionException;
import com.aleynik.notificationservice.exceptions.DeleteFinancialTransactionException;
import com.aleynik.notificationservice.exceptions.ErrorResponse;
import com.aleynik.notificationservice.exceptions.GetAllFinancialTransactionException;
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

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AddFinancialTransactionException.class)
    public ErrorResponse addException(AddFinancialTransactionException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GetAllFinancialTransactionException.class)
    public ErrorResponse getException(GetAllFinancialTransactionException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
