package com.aleynik.generationservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class FinancialTransactionRequest {

    private UUID account;

    private BigDecimal sum;

    private String description;

    private Boolean type;

}
