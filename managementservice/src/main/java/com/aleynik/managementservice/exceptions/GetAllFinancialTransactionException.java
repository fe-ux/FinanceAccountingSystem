package com.aleynik.managementservice.exceptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class GetAllFinancialTransactionException extends RuntimeException {

    public GetAllFinancialTransactionException(String massage) {
        super(massage);
    }
}
