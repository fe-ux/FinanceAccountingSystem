package com.aleynik.managementservice.exceptions;

public class GetAllFinancialTransactionException extends RuntimeException {
    public String massage;

    public GetAllFinancialTransactionException(Exception exception) {
        this.massage = "GET ALL FINANCIAL TRANSACTION ETERNAL EXCEPTION = " + exception.toString();
    }
}
