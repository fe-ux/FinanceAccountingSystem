package com.aleynik.notificationservice.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class NotificationRequest {
    private Boolean status;

    String mail;
}
