package com.aleynik.statisticsservice.dto;

import com.aleynik.statisticsservice.entity.FinancialTransaction;
import com.aleynik.statisticsservice.entity.comparators.DateFinancialTransactionComparator;
import com.aleynik.statisticsservice.entity.comparators.SumFinancialTransactionComparator;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


@Data
public class FinancialTransactionStatisticResponse {

    private BigDecimal allSum;

    private List<FinancialTransaction> financialTransactionList;

    public void sortData(){
        DateFinancialTransactionComparator comparator = new DateFinancialTransactionComparator();
        financialTransactionList.sort(comparator);
    }

    public void sortSum(){
        SumFinancialTransactionComparator comparator = new SumFinancialTransactionComparator();
        financialTransactionList.sort(comparator);
    }

    public void reverse(){
        Collections.reverse(financialTransactionList);
    }
}
