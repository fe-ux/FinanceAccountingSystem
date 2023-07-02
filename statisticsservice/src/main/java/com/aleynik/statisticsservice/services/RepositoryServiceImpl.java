package com.aleynik.statisticsservice.services;

import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticRequest;
import com.aleynik.statisticsservice.entity.FinancialTransaction;
import com.aleynik.statisticsservice.exceptions.DataStatisticsException;
import com.aleynik.statisticsservice.repository.FinancialTransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private FinancialTransactionsRepository financialTransactionsRepository;

    public List<FinancialTransaction> getFinancialTransactions(FinancialTransactionStatisticRequest request) {
        try {
            if (request.getFrom() != null) {
                if (request.getTo() != null)
                    return financialTransactionsRepository.findAllByDateBetweenAndAccount(request.getFrom(), request.getTo(), request.getAccount());
                else
                    return financialTransactionsRepository.findAllByDateAfterAndAccount(request.getFrom(), request.getAccount());
            }
            if (request.getTo() != null)
                return financialTransactionsRepository.findAllByDateBeforeAndAccount(request.getTo(), request.getAccount());
            return financialTransactionsRepository.findAllByAccount(request.getAccount());
        }
        catch (Exception exception){
            throw new DataStatisticsException("BAD DATA | EXCEPTION = " + exception + " | REQUEST = " + request.toString());
        }
    }
}
