package com.aleynik.statisticsservice.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class FinancialTransactionStatisticRequest {

    private UUID account;

    private String filter;

    private Date from;

    private Date to;

}
