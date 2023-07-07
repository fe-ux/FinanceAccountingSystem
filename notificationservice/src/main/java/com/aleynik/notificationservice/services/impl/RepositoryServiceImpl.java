package com.aleynik.notificationservice.services.impl;

import com.aleynik.notificationservice.entity.Notification;
import com.aleynik.notificationservice.exceptions.AddFinancialTransactionException;
import com.aleynik.notificationservice.exceptions.DeleteFinancialTransactionException;
import com.aleynik.notificationservice.exceptions.GetAllFinancialTransactionException;
import com.aleynik.notificationservice.repository.NotificationServiceRepository;
import com.aleynik.notificationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private NotificationServiceRepository notificationServiceRepository;


    public Notification setNotification(Notification request) {
        try {
            notificationServiceRepository.save(request);
        }
        catch (Exception exception) {
            throw new RuntimeException();
        }
        return request;
    }

    public Optional<Notification> checkNotification(UUID id) {
        Optional<Notification> notification;
        try {
            if(notificationServiceRepository.findById(id).isPresent()){
                notification = notificationServiceRepository.findById(id);
            }
            else return null;
        }
        catch (Exception exception){
            throw new RuntimeException();
        }
        return notification;
    }

    public List<Notification> getAllNotifications() {
        try {
            return notificationServiceRepository.findAll();
        }
        catch (Exception exception){
            throw new RuntimeException();
        }
    }
}
