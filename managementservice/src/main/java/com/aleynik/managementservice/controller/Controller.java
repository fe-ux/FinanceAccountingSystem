package com.aleynik.managementservice.controller;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import com.aleynik.managementservice.exceptions.DeleteFinancialTransactionException;
import com.aleynik.managementservice.services.JwtUtils;
import com.aleynik.managementservice.services.ManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class Controller {

    private ManagementService managementService;

    private JwtUtils jwtUtils;


    @PostMapping("/financial_transaction")
    public ResponseEntity<FinancialTransaction> addFinancialTransaction(@RequestHeader HttpHeaders headers ,@RequestBody FinancialTransactionRequest request) {
        return ResponseEntity.ok(managementService.add(request, jwtUtils.getUUID(headers)));
    }

    @DeleteMapping("/financial_transaction")
    public ResponseEntity<Void> addFinancialTransaction(@RequestHeader HttpHeaders headers, @RequestParam Long id) {
        if (!jwtUtils.checkAdmin(headers)) throw new DeleteFinancialTransactionException("ACCESS DENY");
        managementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/financial_transaction")
    public ResponseEntity<List<FinancialTransaction>> getAll(@RequestHeader HttpHeaders headers) {
        if (!jwtUtils.checkAdmin(headers)) throw new DeleteFinancialTransactionException("ACCESS DENY");
        return ResponseEntity.ok(managementService.get());
    }

}
