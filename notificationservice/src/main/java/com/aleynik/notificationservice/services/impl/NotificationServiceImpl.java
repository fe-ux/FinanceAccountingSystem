package com.aleynik.notificationservice.services.impl;

import com.aleynik.notificationservice.dto.FinancialTransaction;
import com.aleynik.notificationservice.dto.NotificationRequest;
import com.aleynik.notificationservice.entity.Notification;
import com.aleynik.notificationservice.exceptions.GetAllNotificationException;
import com.aleynik.notificationservice.exceptions.SetNotificationException;
import com.aleynik.notificationservice.services.NotificationService;
import com.aleynik.notificationservice.services.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private RepositoryService repositoryService;
    private EmailSenderServiceImpl emailSenderService;

    public NotificationRequest set(NotificationRequest request, UUID id) {
        if (request.getStatus() == null || request.getMail() == null)
            throw new SetNotificationException("SET NOTIFICATION EXCEPTION = BAD REQUEST");
        try {
            repositoryService.setNotification(request, id);
        }
        catch (Exception exception){
            throw new SetNotificationException("ETERNAL SET NOTIFICATION EXCEPTION = "+exception);
        }
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
        try {
            return repositoryService.getAllNotifications();
        }
        catch (Exception exception){
            throw new GetAllNotificationException("ETERNAL GET ALL NOTIFICATION EXCEPTION = "+exception);
        }
    }
}
