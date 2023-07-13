package com.aleynik.managementservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class GeneratingRequest {

    private UUID id;

    private BigDecimal sum;

    private String description;

    private Boolean type;

    public FinancialTransactionRequest getFinancialTransactionRequest(){
        return FinancialTransactionRequest.builder().description(this.description).sum(this.sum).type(this.type).build();
    }
}