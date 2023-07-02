package com.aleynik.statisticsservice.services;

import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticRequest;
import com.aleynik.statisticsservice.entity.FinancialTransaction;

import java.util.List;

public interface RepositoryService {
    List<FinancialTransaction> getFinancialTransactions(FinancialTransactionStatisticRequest request);
}
