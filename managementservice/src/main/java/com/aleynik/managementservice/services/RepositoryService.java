package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;

import java.util.List;

public interface RepositoryService {

    FinancialTransaction addFinancialTransaction(FinancialTransactionRequest request);

    void deleteFinancialTransaction(Long id);

    List<FinancialTransaction> getAllTransaction();

}
