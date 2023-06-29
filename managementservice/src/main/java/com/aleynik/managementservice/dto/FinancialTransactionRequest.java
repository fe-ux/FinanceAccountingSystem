package com.aleynik.managementservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class FinancialTransactionRequest {

    private UUID id_user;

    private BigDecimal sum;

    private String description;

    private Boolean type;

}
