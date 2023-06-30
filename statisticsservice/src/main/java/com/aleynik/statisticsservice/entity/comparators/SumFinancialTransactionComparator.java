package com.aleynik.statisticsservice.entity.comparators;

import com.aleynik.statisticsservice.entity.FinancialTransaction;

import java.util.Comparator;

public class SumFinancialTransactionComparator implements Comparator<FinancialTransaction> {

    public int compare(FinancialTransaction o1, FinancialTransaction o2) {
        if(o1.getType().compareTo(o2.getType()) > 0) return 1;
        if(o1.getType().compareTo(o2.getType()) < 0) return -1;
        if(o1.getSum().compareTo(o2.getSum()) == 0) return 0;
        if(o1.getType())
            if(o1.getSum().compareTo(o2.getSum()) > 0) return 1;
            else return -1;
        if(o1.getSum().compareTo(o2.getSum()) > 0) return -1;
        else return 1;
    }
}
