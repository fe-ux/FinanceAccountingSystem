package com.aleynik.managementservice.services;

import com.aleynik.managementservice.repository.FinancialTransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;

@AllArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService{

    private RepositoryService repositoryService;

    @Override
    public ResponseEntity<?> requestService(LinkedHashMap<String, Object> request) {
        try {
            if (request.get("delete") != null) {
                if ((boolean) request.get("delete")) return repositoryService.deleteFinancialTransaction(request);
            }
            if (request.get("add") != null) {
                if ((boolean) request.get("add")) return repositoryService.addFinancialTransaction(request);
            }
        }
        catch (ClassCastException exception) {
            return new ResponseEntity<>("Bad delete/add", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Request don't have delete/add",HttpStatus.BAD_REQUEST);
    }
}
