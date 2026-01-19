package com.example.demo.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="users")
public class User {
    String name;
    @Id
    String id;

    public User(String name, String id)
    {
        this.name=name;
        this.id=id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
}
