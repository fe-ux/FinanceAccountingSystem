package com.aleynik.managementservice.controller;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import com.aleynik.managementservice.services.ManagementService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class Controller {

    private ManagementService managementService;

    @PostMapping("/financial_transaction")
    public ResponseEntity<FinancialTransaction> addFinancialTransaction(@RequestBody FinancialTransactionRequest request) {
        return ResponseEntity.ok(managementService.add(request));
    }

    @DeleteMapping("/financial_transaction")
    public ResponseEntity<Void> addFinancialTransaction(@RequestParam Long id) {
        managementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/financial_transaction")
    public ResponseEntity<List<FinancialTransaction>> getAll() {
       return ResponseEntity.ok(managementService.get());
    }

    @KafkaListener(id = "ManagementService",topics = "generationtransactions")
    private void generationFinancialTransaction(String massage){
        Gson gson = new Gson();
        managementService.add(gson.fromJson(massage,FinancialTransactionRequest.class));
    }

}
