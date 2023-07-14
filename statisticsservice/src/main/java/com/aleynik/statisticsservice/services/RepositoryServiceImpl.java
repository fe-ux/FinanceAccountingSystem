package com.aleynik.statisticsservice.services;

import com.aleynik.statisticsservice.dto.FinancialTransactionStatisticRequest;
import com.aleynik.statisticsservice.entity.FinancialTransaction;
import com.aleynik.statisticsservice.exceptions.DataStatisticsException;
import com.aleynik.statisticsservice.repository.FinancialTransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private FinancialTransactionsRepository financialTransactionsRepository;

    public List<FinancialTransaction> getFinancialTransactions(FinancialTransactionStatisticRequest request, UUID id) {
        try {
            if (request.getFrom() != null) {
                if (request.getTo() != null)
                    return financialTransactionsRepository.findAllByDateBetweenAndAccount(request.getFrom(), request.getTo(), id);
                else
                    return financialTransactionsRepository.findAllByDateAfterAndAccount(request.getFrom(), id);
            }
            if (request.getTo() != null)
                return financialTransactionsRepository.findAllByDateBeforeAndAccount(request.getTo(), id);
            return financialTransactionsRepository.findAllByAccount(id);
        }
        catch (Exception exception){
            throw new DataStatisticsException("BAD DATA | EXCEPTION = " + exception + " | REQUEST = " + request.toString());
        }
    }
}
