package com.aleynik.notificationservice.services;

import com.aleynik.notificationservice.entity.Notification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryService {

    Notification setNotification(Notification request);

    Optional<Notification> checkNotification(UUID id);

    List<Notification> getAllNotifications();

}
