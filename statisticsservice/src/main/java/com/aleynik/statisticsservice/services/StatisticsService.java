package com.aleynik.statisticsservice.services;

import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticRequest;
import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticsService {
    FinancialTransactionStatisticResponse get(FinancialTransactionStatisticRequest request);

}
