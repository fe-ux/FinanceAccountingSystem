package com.aleynik.statisticsservice.entity.comparators;

import com.aleynik.statisticsservice.entity.FinancialTransaction;


import java.util.Comparator;

public class DateFinancialTransactionComparator implements Comparator<FinancialTransaction> {
    public int compare(FinancialTransaction o1, FinancialTransaction o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
