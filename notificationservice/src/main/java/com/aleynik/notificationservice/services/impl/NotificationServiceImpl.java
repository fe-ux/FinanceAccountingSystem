package com.aleynik.notificationservice.services.impl;

import com.aleynik.notificationservice.dto.FinancialTransaction;
import com.aleynik.notificationservice.entity.Notification;
import com.aleynik.notificationservice.services.NotificationService;
import com.aleynik.notificationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private RepositoryService repositoryService;
    private EmailSenderServiceImpl emailSenderService;

    public Notification set(Notification request) {
        if (request.getStatus() == null || request.getId() == null || request.getMail() == null)
            throw new RuntimeException();
        repositoryService.setNotification(request);
        return request;
    }


    public void sendMassage(FinancialTransaction financialTransaction) {
        Optional<Notification> notification = repositoryService.checkNotification(financialTransaction.getAccount());
        if(notification.isPresent())
            if(notification.get().getStatus()){
                emailSenderService.sendEmail(
                        notification.get().getMail(),
                        "Transaction",
                        financialTransaction.toString());
            }
    }


    public List<Notification> get() {
        return repositoryService.getAllNotifications();
    }
}
