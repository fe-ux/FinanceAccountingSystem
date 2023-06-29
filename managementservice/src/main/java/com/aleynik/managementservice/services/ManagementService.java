package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.TransactionRequest;
import com.aleynik.managementservice.dto.TransactionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public interface ManagementService {

    TransactionResponse add(TransactionRequest request);

    void delete(Long id);

    List<TransactionResponse> get();
}
