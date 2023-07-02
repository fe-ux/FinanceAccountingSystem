package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService {

    private RepositoryService repositoryService;

    public FinancialTransaction add(FinancialTransactionRequest request) {
        return repositoryService.addFinancialTransaction(request);
    }

    public void delete(Long id) {
        repositoryService.deleteFinancialTransaction(id);
    }

    public List<FinancialTransaction> get() {
        return repositoryService.getAllTransaction();
    }
}
