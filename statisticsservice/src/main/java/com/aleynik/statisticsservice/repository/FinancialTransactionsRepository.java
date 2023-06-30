package com.aleynik.statisticsservice.repository;

import com.aleynik.statisticsservice.entity.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

public interface FinancialTransactionsRepository extends JpaRepository<FinancialTransaction, Long> {
    LinkedList<FinancialTransaction> findAllByDateBetweenAndAccount(Date from, Date to, UUID account);

    LinkedList<FinancialTransaction> findAllByDateBeforeAndAccount(Date to,UUID account);

    LinkedList<FinancialTransaction> findAllByDateAfterAndAccount(Date from,UUID account);

    LinkedList<FinancialTransaction> findAllByAccount(UUID account);
}
