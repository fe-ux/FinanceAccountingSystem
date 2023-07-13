package com.aleynik.notificationservice.services.impl;

import com.aleynik.notificationservice.dto.NotificationRequest;
import com.aleynik.notificationservice.entity.Notification;
import com.aleynik.notificationservice.exceptions.SetNotificationException;
import com.aleynik.notificationservice.repository.NotificationServiceRepository;
import com.aleynik.notificationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class RepositoryServiceImpl implements RepositoryService {

    private NotificationServiceRepository notificationServiceRepository;


    public NotificationRequest setNotification(NotificationRequest request, UUID id) {
        Notification notification = Notification.builder().id(id).mail(request.getMail()).status(request.getStatus()).build();
        notificationServiceRepository.save(notification);
        return request;
    }

    public Optional<Notification> checkNotification(UUID id) {
        Optional<Notification> notification;
        if(notificationServiceRepository.findById(id).isPresent()){
                notification = notificationServiceRepository.findById(id);
        }
        else return null;
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
