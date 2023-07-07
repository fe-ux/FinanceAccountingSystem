package com.aleynik.notificationservice.services;

import com.aleynik.notificationservice.dto.FinancialTransaction;
import com.aleynik.notificationservice.entity.Notification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface NotificationService {

    Notification set(Notification request);

    void sendMassage(FinancialTransaction financialTransaction);

    List<Notification> get();
}
