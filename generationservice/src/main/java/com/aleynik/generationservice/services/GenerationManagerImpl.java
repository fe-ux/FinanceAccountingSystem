package com.aleynik.generationservice.services;

import com.aleynik.generationservice.dto.GenerationRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenerationManagerImpl implements GenerationManager {
    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplateAccounts;
    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplateTransactions;
    @Autowired
    private GeneratorRandom generatorRandom;
    private boolean status = true;

    public void start(GenerationRequest request) {
        Gson gson = new Gson();
        try {
            for (int i = 0; i < request.getAmountAccount(); i++) {
                UUID uuid;
                uuid = UUID.randomUUID();
                kafkaTemplateAccounts.send(
                        "generationaccounts",
                        gson.toJson(generatorRandom.generationAccount(uuid))
                );
                new ThreadFinancialTransactions(String.valueOf(i), uuid, request, this, kafkaTemplateTransactions).start();
            }
        }
        catch (Exception exception){
            throw new RuntimeException();
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void stop() {
        status = false;
    }



}
