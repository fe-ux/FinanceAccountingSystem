package com.aleynik.statisticsservice.controller;

import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticRequest;
import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticResponse;
import com.aleynik.statisticsservice.services.JwtUtils;
import com.aleynik.statisticsservice.services.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class Controller {

    private StatisticsService statisticsService;

    private JwtUtils jwtUtils;

    @GetMapping("/statistic")
    public ResponseEntity<FinancialTransactionStatisticResponse> getAll(@RequestHeader HttpHeaders headers, @RequestBody FinancialTransactionStatisticRequest request) {
       return ResponseEntity.ok(statisticsService.get(request, jwtUtils.getUUID(headers)));
    }

}
