package com.aleynik.generationservice.services;

import com.aleynik.generationservice.dto.FinancialTransactionRequest;

import com.aleynik.generationservice.dto.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@Service
public class GeneratorRandomImpl implements GeneratorRandom{
    private final Random random = new Random();
    private final StringBuilder result = new StringBuilder();

    public Account generationAccount(UUID uuid){
        return Account.builder()
                .id(uuid)
                .mail(randomString(10) + "@mymail.ru")
                .login(randomString(15))
                .password(randomString(15))
                .firstname(randomString(7))
                .lastname(randomString(10))
                .surname(randomString(10))
                .build();
    }

    public FinancialTransactionRequest generationTransactionRequest(UUID uuid, BigDecimal allSum){
        double addSum = random.nextGaussian(0,100000);
        boolean type = !(addSum < 0);
        if(allSum.add(BigDecimal.valueOf(addSum)).compareTo(new BigDecimal(0)) < 0) {
            type = true;
        }
        return
                FinancialTransactionRequest.builder()
                        .account(uuid)
                        .type(type)
                        .description(randomString(20))
                        .sum(BigDecimal.valueOf(Math.abs(addSum)))
                        .build();
    }

    public String randomString(int length){
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; //62
        result.delete(0,result.length());
        for(int i = 0; i < length; i++){
            result.append(abc.charAt(random.nextInt(62)));
        }
        return result.toString();
    }
}
