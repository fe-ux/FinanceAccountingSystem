package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.TransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import com.aleynik.managementservice.exceptions.DeleteFinancialTransactionException;
import com.aleynik.managementservice.repository.FinancialTransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.UUID;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private FinancialTransactionsRepository financialTransactionsRepository;

    @Override
    public ResponseEntity<?> addFinancialTransaction(LinkedHashMap<String, Object> request) {

        FinancialTransaction financialTransaction = new FinancialTransaction();

        if (request.get("id_user") == null)
            return new ResponseEntity<>("Request don't have id_user", HttpStatus.BAD_REQUEST);
        try {
            financialTransaction.setId_user(UUID.fromString(request.get("id_user").toString()));
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>("Bad id_user", HttpStatus.BAD_REQUEST);
        }


        if (request.get("sum") == null)
            return new ResponseEntity<>("Request don't have sum", HttpStatus.BAD_REQUEST);
        try {
            if (Double.parseDouble(request.get("sum").toString()) <= 0)
                return new ResponseEntity<>("Bad sum", HttpStatus.BAD_REQUEST);
            financialTransaction.setSum(BigDecimal.valueOf(Double.parseDouble(request.get("sum").toString())));
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>("Bad sum", HttpStatus.BAD_REQUEST);
        }


        if (request.get("type") == null)
            return new ResponseEntity<>("Request don't have type", HttpStatus.BAD_REQUEST);
        try {
            financialTransaction.setType(Boolean.valueOf(request.get("type").toString()));
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>("Bad type", HttpStatus.BAD_REQUEST);
        }

        financialTransaction.setId(financialTransactionsRepository.count() + 1L);
        financialTransaction.setDate(Date.from(Instant.now()));
        if (request.get("description") != null & request.get("description") instanceof String)
            financialTransaction.setDescription(request.get("description").toString());

        financialTransactionsRepository.save(financialTransaction);

        return new ResponseEntity<>("Financial transaction added", HttpStatus.OK);
    }

    @Override
    public void deleteFinancialTransaction(Long id) {
        if (id == null)
            throw new DeleteFinancialTransactionException("Request don't have id");
        try {
            financialTransactionsRepository.deleteById(id);
        } catch (IllegalArgumentException exception) {
            throw new DeleteFinancialTransactionException("Bad id");
        }
    }
}
