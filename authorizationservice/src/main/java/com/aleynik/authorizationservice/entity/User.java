package com.aleynik.authorizationservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table( name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(max = 50)
    @NotBlank
    private String firstname;

    @Size(max = 50)
    @NotBlank
    String lastname;

    @Size(max = 50)
    @NotBlank
    String surname;

    @Email
    @Size(max = 50)
    @NotBlank
    String email;

    @Size(max = 20)
    @NotBlank
    String username;

    @Size(max = 150)
    @NotBlank
    String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User(String firstname, String lastname, String surname, String username, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
