package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.TransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@AllArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService {

    private RepositoryService repositoryService;

    public TransactionRequest add(TransactionRequest request) {
        return repositoryService.addFinancialTransaction(request);
    }

    public void delete(Long id) {
        repositoryService.deleteFinancialTransaction(id);
    }
}
