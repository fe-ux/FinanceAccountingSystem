package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ManagementService {

    FinancialTransaction add(FinancialTransactionRequest request, UUID id);

    void delete(Long id);

    List<FinancialTransaction> get();
}
