package com.aleynik.notificationservice.services;

import com.aleynik.notificationservice.dto.NotificationRequest;
import com.aleynik.notificationservice.entity.Notification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryService {

    NotificationRequest setNotification(NotificationRequest request, UUID id);

    Optional<Notification> checkNotification(UUID id);

    List<Notification> getAllNotifications();

}
