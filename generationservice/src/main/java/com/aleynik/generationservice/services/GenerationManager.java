package com.aleynik.generationservice.services;

import com.aleynik.generationservice.dto.GenerationRequest;

public interface GenerationManager {
    void start(GenerationRequest request);

    void stop();

    public boolean isStatus();
}
