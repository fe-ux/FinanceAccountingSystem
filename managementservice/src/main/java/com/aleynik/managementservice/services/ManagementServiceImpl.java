package com.aleynik.managementservice.services;

import com.aleynik.managementservice.dto.FinancialTransactionRequest;
import com.aleynik.managementservice.entity.FinancialTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService {

    private KafkaTemplate<Integer, String> kafkaTemplateNotification;

    private RepositoryService repositoryService;

    public FinancialTransaction add(FinancialTransactionRequest request, UUID id) {
        FinancialTransaction financialTransaction = repositoryService.addFinancialTransaction(request, id);
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
