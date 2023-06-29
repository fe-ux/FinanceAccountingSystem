package com.aleynik.managementservice.services;

import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;

public interface RepositoryService {

    public ResponseEntity<?> addFinancialTransaction(LinkedHashMap<String, Object> request);

    public ResponseEntity<?> deleteFinancialTransaction(LinkedHashMap<String, Object> request);
}
