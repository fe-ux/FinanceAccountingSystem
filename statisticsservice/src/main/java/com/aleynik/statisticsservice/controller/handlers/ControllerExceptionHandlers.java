package com.aleynik.statisticsservice.controller.handlers;

import com.aleynik.statisticsservice.exceptions.DataStatisticsException;
import com.aleynik.statisticsservice.exceptions.ErrorResponse;
import com.aleynik.statisticsservice.exceptions.SetFilterException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandlers {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataStatisticsException.class)
    public ErrorResponse deleteException(DataStatisticsException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SetFilterException.class)
    public ErrorResponse deleteException(SetFilterException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
