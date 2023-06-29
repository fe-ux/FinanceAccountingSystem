package com.aleynik.managementservice.repository;

import com.aleynik.managementservice.entity.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialTransactionsRepository extends JpaRepository<FinancialTransaction, Long> {
}
