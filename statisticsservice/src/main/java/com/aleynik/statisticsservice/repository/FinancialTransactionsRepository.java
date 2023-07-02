package com.aleynik.statisticsservice.repository;

import com.aleynik.statisticsservice.entity.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface FinancialTransactionsRepository extends JpaRepository<FinancialTransaction, Long> {
    List<FinancialTransaction> findAllByDateBetweenAndAccount(Date from, Date to, UUID account);

    List<FinancialTransaction> findAllByDateBeforeAndAccount(Date to,UUID account);

    List<FinancialTransaction> findAllByDateAfterAndAccount(Date from,UUID account);

    List<FinancialTransaction> findAllByAccount(UUID account);
}
