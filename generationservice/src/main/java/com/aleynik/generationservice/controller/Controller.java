package com.aleynik.generationservice.controller;

import com.aleynik.generationservice.dto.GenerationRequest;
import com.aleynik.generationservice.services.GenerationService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class Controller {

    private GenerationService generationService;

    @PostMapping("/generation")
    public ResponseEntity<GenerationRequest> setSettings(@RequestBody GenerationRequest request) {
        return ResponseEntity.ok(generationService.settings(request));
    }

    @PutMapping("/generation")
    public ResponseEntity<String> setStatus(@Param("status") Boolean status) {
        return ResponseEntity.ok(generationService.status(status));
    }

}
