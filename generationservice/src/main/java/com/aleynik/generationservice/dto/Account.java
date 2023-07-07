package com.aleynik.generationservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@Builder
public class Account {
    UUID id;

    String firstname;

    String lastname;

    String surname;

    String mail;

    String login;

    String password;

}