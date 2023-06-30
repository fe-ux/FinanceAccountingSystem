package com.aleynik.statisticsservice.services;

import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticRequest;
import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticResponse;
import com.aleynik.statisticsservice.exceptions.SetFilterException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class StatisticsServiceImpl implements StatisticsService {

    private RepositoryService repositoryService;

    public FinancialTransactionStatisticResponse get(FinancialTransactionStatisticRequest request) {

        FinancialTransactionStatisticResponse response = new FinancialTransactionStatisticResponse();

        response.setFinancialTransactionList(repositoryService.getFinancialTransaction(request));

        if (request.getFilter() != null) {
            switch (request.getFilter()) {
                case ("newer") -> response.sortData();
                case ("older") -> {
                    response.sortData();
                    response.reverse();
                }
                case ("cheaper") -> response.sortSum();
                case ("expensive") -> {
                    response.sortSum();
                    response.reverse();
                }
                default -> throw new SetFilterException("BAD FILTER = " + request);
            }
        }

        response.setIncomeSum(
                response.getFinancialTransactionList()
                        .stream()
                        .map(e -> e.getSum().multiply(new BigDecimal(e.getType() ? 1: 0)))
                        .reduce(BigDecimal.ZERO,BigDecimal::add));

        response.setExpensesSum(
                response.getFinancialTransactionList()
                        .stream()
                        .map(e -> e.getSum().multiply(new BigDecimal(e.getType() ? 0: 1)))
                        .reduce(BigDecimal.ZERO,BigDecimal::add));

        response.setAllSum(response.getIncomeSum().subtract(response.getExpensesSum()));

        return response;
    }
}
