package com.aleynik.generationservice.services;

import com.aleynik.generationservice.dto.FinancialTransactionRequest;
import com.aleynik.generationservice.dto.GenerationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import com.google.gson.*;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;


public class ThreadFinancialTransactions extends Thread {

    @Autowired
    private final KafkaTemplate<Integer, String> kafkaTemplateTransactions;
    private final Random random = new Random();
    private final UUID account;
    private BigDecimal sum = new BigDecimal(0);
    private final GeneratorRandomImpl generatorRandomImpl = new GeneratorRandomImpl();
    private final GenerationRequest generationRequest;
    private final GenerationManager generationManager;

    ThreadFinancialTransactions(String number, UUID account,
                                GenerationRequest generationRequest, GenerationManager generationManager,
                                KafkaTemplate<Integer, String> kafkaTemplateTransactions) {
        super(number);
        this.account = account;
        this.generationRequest = generationRequest;
        this.generationManager = generationManager;
        this.kafkaTemplateTransactions = kafkaTemplateTransactions;
    }

    public void run() {
        Gson gson = new Gson();
        while (generationManager.isStatus()) {
            FinancialTransactionRequest financialTransactionRequest = generatorRandomImpl.generationTransactionRequest(account, sum);
            kafkaTemplateTransactions.send(
                    "generationtransactions",
                    gson.toJson(financialTransactionRequest)
            );
            sum = sum.add(
                    financialTransactionRequest.getSum()
                    .multiply(new BigDecimal(financialTransactionRequest.getType() ? 1 : -1))
            );

            try {
                sleep((long)random.nextGaussian(generationRequest.getMeanTimeTransaction(),generationRequest.getStdDeviationTimeTransaction()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
