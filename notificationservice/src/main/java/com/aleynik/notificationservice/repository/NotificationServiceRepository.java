package com.aleynik.notificationservice.repository;

import com.aleynik.notificationservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationServiceRepository extends JpaRepository<Notification, UUID> {

}
