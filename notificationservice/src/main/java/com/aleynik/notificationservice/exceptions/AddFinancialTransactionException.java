package com.aleynik.notificationservice.exceptions;

public class AddFinancialTransactionException extends RuntimeException{
    public AddFinancialTransactionException(String massage) {
        super(massage);
    }
}