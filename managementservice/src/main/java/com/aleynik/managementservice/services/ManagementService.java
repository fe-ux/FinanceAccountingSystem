package com.aleynik.managementservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;

@Service
public interface ManagementService {

    public ResponseEntity<?> requestService(LinkedHashMap<String, Object> request);
}
