package com.aleynik.managementservice.exceptions;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
public class AddFinancialTransactionException extends RuntimeException{
    public String massage;
    public AddFinancialTransactionException(String massage, FinancialTransactionRequest request) {
        this.massage = massage + request.toString();
    }
    public AddFinancialTransactionException(String massage, FinancialTransactionRequest request, Exception exception){
        this.massage = massage + request.toString()+" | EXCEPTION = "+exception.toString();
    }
}