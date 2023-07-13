package com.aleynik.notificationservice.controller.handlers;
import com.aleynik.notificationservice.exceptions.ErrorResponse;
import com.aleynik.notificationservice.exceptions.GetAllNotificationException;
import com.aleynik.notificationservice.exceptions.SetNotificationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerExceptionHandlers {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(GetAllNotificationException.class)
    public ErrorResponse deleteException(GetAllNotificationException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SetNotificationException.class)
    public ErrorResponse deleteException(SetNotificationException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
