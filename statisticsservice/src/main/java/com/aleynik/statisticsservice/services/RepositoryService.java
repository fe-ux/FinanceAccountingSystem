package com.aleynik.statisticsservice.services;

import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticRequest;
import com.aleynik.statisticsservice.entity.FinancialTransaction;

import java.util.List;
import java.util.UUID;

public interface RepositoryService {
    List<FinancialTransaction> getFinancialTransactions(FinancialTransactionStatisticRequest request, UUID id);
}
