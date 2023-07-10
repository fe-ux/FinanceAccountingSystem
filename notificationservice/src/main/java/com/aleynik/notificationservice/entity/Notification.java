package com.aleynik.notificationservice.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Builder
@Entity(name = "notification")
public class Notification {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(name = "status", updatable = false, nullable = false)
    private Boolean status;

    @Column(name = "mail", updatable = false, nullable = false)
    String mail;
}
