package com.aleynik.generationservice.services;

import com.aleynik.generationservice.dto.GenerationRequest;
import org.springframework.stereotype.Service;


@Service
public interface GenerationService {

    GenerationRequest settings(GenerationRequest request);
    String status(Boolean status);



}
