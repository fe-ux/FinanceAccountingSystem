package com.aleynik.managementservice.exceptions;

public class AddFinancialTransactionException extends RuntimeException{
    public AddFinancialTransactionException(String massage) {
        super(massage);
    }
}