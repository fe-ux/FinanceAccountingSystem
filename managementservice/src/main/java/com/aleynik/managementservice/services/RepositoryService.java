package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;

import java.util.List;
import java.util.UUID;

public interface RepositoryService {

    FinancialTransaction addFinancialTransaction(FinancialTransactionRequest request, UUID id);

    void deleteFinancialTransaction(Long id);

    List<FinancialTransaction> getAllTransaction();

}
