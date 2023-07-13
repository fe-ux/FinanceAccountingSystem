package com.aleynik.notificationservice.services;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}
