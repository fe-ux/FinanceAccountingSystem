package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagementService {

    FinancialTransaction add(FinancialTransactionRequest request);

    void delete(Long id);

    List<FinancialTransaction> get();
}
