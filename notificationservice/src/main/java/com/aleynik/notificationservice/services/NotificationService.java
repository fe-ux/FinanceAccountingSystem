package com.aleynik.notificationservice.services;

import com.aleynik.notificationservice.dto.FinancialTransaction;
import com.aleynik.notificationservice.dto.NotificationRequest;
import com.aleynik.notificationservice.entity.Notification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface NotificationService {

    NotificationRequest set(NotificationRequest request, UUID id);

    void sendMassage(FinancialTransaction financialTransaction);

    List<Notification> get();
}
