package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final AppUserRepository repository;

    public UserService(AppUserRepository repository) {
        this.repository = repository;
    }

    public AppUser createUser(AppUser user) {
        return repository.save(user);
    }

    public List<AppUser> getAllUsers() {
        return repository.findAll();
    }
}
