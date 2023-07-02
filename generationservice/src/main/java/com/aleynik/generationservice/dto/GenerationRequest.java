package com.aleynik.generationservice.dto;

import lombok.Data;

@Data
public class GenerationRequest {
    int amountAccount;
    int meanTimeTransaction;
    int stdDeviationTimeTransaction;
}
