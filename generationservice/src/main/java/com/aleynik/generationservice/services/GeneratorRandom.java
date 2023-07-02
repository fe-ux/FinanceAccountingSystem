package com.aleynik.generationservice.services;

import com.aleynik.generationservice.dto.FinancialTransactionRequest;
import com.aleynik.generationservice.dto.Account;

import java.math.BigDecimal;
import java.util.UUID;

public interface GeneratorRandom {
    FinancialTransactionRequest generationTransactionRequest(UUID uuid, BigDecimal allSum);

    String randomString(int length);

    Account generationAccount(UUID uuid);

}
