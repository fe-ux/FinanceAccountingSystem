package com.aleynik.notificationservice.controller;

import com.aleynik.notificationservice.dto.FinancialTransaction;
import com.aleynik.notificationservice.dto.NotificationRequest;
import com.aleynik.notificationservice.entity.Notification;
import com.aleynik.notificationservice.exceptions.GetAllNotificationException;
import com.aleynik.notificationservice.services.NotificationService;
import com.aleynik.notificationservice.services.impl.JwtUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class Controller {

    private NotificationService notificationService;

    private JwtUtils jwtUtils;

    @PostMapping("/notification")
    public ResponseEntity<NotificationRequest> addFinancialTransaction(@RequestHeader HttpHeaders headers, @RequestBody NotificationRequest request) {
        return ResponseEntity.ok(notificationService.set(request,jwtUtils.getUUID(headers)));
    }

    @GetMapping("/notification")
    public ResponseEntity<List<Notification>> getAll(@RequestHeader HttpHeaders headers) {
        if (!jwtUtils.checkAdmin(headers)) throw new GetAllNotificationException("GET ALL NOTIFICATION EXCEPTION = ACCESS DENY");
        return ResponseEntity.ok(notificationService.get());
    }

    @KafkaListener(id = "NotificationService",topics = "notification")
    private void generationFinancialTransaction(String massage){
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy HH:mm:ss").create();
        notificationService.sendMassage(gson.fromJson(massage, FinancialTransaction.class));
    }



}
