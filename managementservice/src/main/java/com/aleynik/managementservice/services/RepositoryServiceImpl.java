package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import com.aleynik.managementservice.exceptions.AddFinancialTransactionException;
import com.aleynik.managementservice.exceptions.DeleteFinancialTransactionException;
import com.aleynik.managementservice.exceptions.GetAllFinancialTransactionException;
import com.aleynik.managementservice.repository.FinancialTransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private FinancialTransactionsRepository financialTransactionsRepository;

    @Override
    public FinancialTransaction addFinancialTransaction(FinancialTransactionRequest request) {

        FinancialTransaction financialTransaction = new FinancialTransaction();

        if (request.getAccount() == null)
            throw new AddFinancialTransactionException("BAD ACCOUNT | REQUEST = " + request);
        financialTransaction.setAccount(request.getAccount());

        if  ((request.getSum() == null) || (request.getSum().compareTo(new BigDecimal(0)) < 0) ||
                (financialTransactionsRepository.findAllByAccount(request.getAccount())
                .stream()
                .map(e -> e.getSum().multiply(new BigDecimal(e.getType() ? 1: -1)))
                .reduce(BigDecimal.ZERO,BigDecimal::add)
                        .add(request.getSum())
                        .compareTo(new BigDecimal(0)) < 0)
        )
            throw new AddFinancialTransactionException("BAD SUM | REQUEST = " + request);
        financialTransaction.setSum(request.getSum());

        if (request.getType() == null)
            throw new AddFinancialTransactionException("BAD TYPE | REQUEST = " + request);
        financialTransaction.setType(request.getType());


        financialTransaction.setId(financialTransactionsRepository.count() + 1L);
        financialTransaction.setDate(Date.from(Instant.now()));
        if (request.getDescription() != null)
            if(request.getDescription().length() > 100)
                throw new AddFinancialTransactionException("BAD DESCRIPTION | REQUEST = " + request);
        financialTransaction.setDescription(request.getDescription());

        try {
            financialTransactionsRepository.save(financialTransaction);
        } catch (Exception exception) {
            throw new AddFinancialTransactionException("ETERNAL EXCEPTION | REQUEST = " + request + " | EXCEPTION = " + exception);
        }

        return financialTransaction;
    }

    @Override
    public void deleteFinancialTransaction(Long id) {
        if (id == null)
            throw new DeleteFinancialTransactionException("BAD ID = " + null);
        try {
            financialTransactionsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new DeleteFinancialTransactionException("BAD ID = " + id);
        }
    }

    @Override
    public List<FinancialTransaction> getAllTransaction() {
        try {
            return financialTransactionsRepository.findAll();
        } catch (Exception exception) {
            throw new GetAllFinancialTransactionException("GET ALL FINANCIAL TRANSACTION ETERNAL EXCEPTION = " + exception);
        }
    }

}
