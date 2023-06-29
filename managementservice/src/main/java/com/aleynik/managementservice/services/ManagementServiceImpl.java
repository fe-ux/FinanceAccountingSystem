package com.aleynik.managementservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@AllArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService {

    private RepositoryService repositoryService;

    @Override
    public void requestService(LinkedHashMap<String, Object> request) {
        if (request.get("delete") != null && ((boolean) request.get("delete"))) {
            repositoryService.deleteFinancialTransaction(request);

        }
        if (request.get("add") != null && ((boolean) request.get("add"))) {
            repositoryService.addFinancialTransaction(request);
        }
    }
}
