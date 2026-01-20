package com.example.demo.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    // JPA requires a no-arg constructor
    public User() {}

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() { return name; }
    public String getId() { return id; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setId(String id) { this.id = id; }
}
