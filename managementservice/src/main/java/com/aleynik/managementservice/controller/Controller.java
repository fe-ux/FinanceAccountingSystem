package com.aleynik.managementservice.controller;

import com.aleynik.managementservice.dto.TransactionRequest;
import com.aleynik.managementservice.dto.TransactionResponse;
import com.aleynik.managementservice.services.ManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class Controller {

    private ManagementService managementService;

    @PostMapping("/financial_transaction")
    public ResponseEntity<TransactionResponse> addFinancialTransaction(@RequestBody TransactionRequest request) {
        managementService.add(request);
        return ResponseEntity.ok(managementService.add(request));
    }

    @DeleteMapping("/financial_transaction")
    public ResponseEntity<Void> addFinancialTransaction(@RequestParam Long id) {
        managementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/financial_transaction")
    public ResponseEntity<List<TransactionResponse>> getAll() {
       return ResponseEntity.ok(managementService.get());
    }

}
