package com.aleynik.authorizationservice.dto.request;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.*;

import java.util.Set;

@Data
public class RegistrationRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  @Size(max = 50)
  @NotBlank
  private String firstname;

  @Size(max = 50)
  @NotBlank
  String lastname;

  @Size(max = 50)
  @NotBlank
  String surname;
}
