package com.aleynik.generationservice.services;

import com.aleynik.generationservice.dto.GenerationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GenerationServiceImpl implements GenerationService {

    private GenerationRequest request;
    @Autowired
    private GenerationManager generationManager;

    public GenerationRequest settings(GenerationRequest request) {
        if (request.getAmountAccount() < 1
                || request.getMeanTimeTransaction() < 1
                || request.getStdDeviationTimeTransaction() < 1
                || request.getMeanTimeTransaction() - request.getStdDeviationTimeTransaction()*3.5 < 0)
            throw new RuntimeException();
        this.request = request;
        return request;
    }

    public String status(Boolean status) {
        if (status == null) throw new RuntimeException();
        if (status){
            generationManager.start(request);
            return "Start";
        }
        else {
            generationManager.stop();
            return "Stop";
        }
    }
}
