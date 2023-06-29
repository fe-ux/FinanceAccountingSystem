package com.aleynik.managementservice.controller;

import com.aleynik.managementservice.services.ManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@AllArgsConstructor
public class Controller {

    private ManagementService managementService;

    @PostMapping("/financialtransaction")
    public ResponseEntity<Void> addFinancialTransaction(@RequestBody LinkedHashMap<String, Object> request) {
        managementService.requestService(request);
        return ResponseEntity.noContent().build();
    }
}
