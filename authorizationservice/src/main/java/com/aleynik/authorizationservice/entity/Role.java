package com.aleynik.authorizationservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Setter
@Getter
@ToString
public class Role {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false, length = 32, unique = true)
    private String name;

    public Role() { }

    public Role(String name) {
        this.name = name;
    }

    public Role(Integer id) {
        super();
        this.id = id;
    }
}
