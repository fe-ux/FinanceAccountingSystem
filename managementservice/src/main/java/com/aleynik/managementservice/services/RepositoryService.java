package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.TransactionRequest;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;

public interface RepositoryService {

    public ResponseEntity<?> addFinancialTransaction(LinkedHashMap<String, Object> request);

    void deleteFinancialTransaction(Long id);
    void deleteFinancialTransaction(TransactionRequest request);
}
