package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService {

    private KafkaTemplate<Integer, String> kafkaTemplateNotification;

    private RepositoryService repositoryService;

    public FinancialTransaction add(FinancialTransactionRequest request) {
        FinancialTransaction financialTransaction = repositoryService.addFinancialTransaction(request);
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss").create();
        kafkaTemplateNotification.send(
                "notification",
                gson.toJson(financialTransaction)
        );
        return financialTransaction;
    }

    public void delete(Long id) {
        repositoryService.deleteFinancialTransaction(id);
    }

    public List<FinancialTransaction> get() {
        return repositoryService.getAllTransaction();
    }
}
