package com.aleynik.managementservice.repository;

import com.aleynik.managementservice.entity.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FinancialTransactionsRepository extends JpaRepository<FinancialTransaction, Long> {

    List<FinancialTransaction> findAllByAccount(UUID account);

}
