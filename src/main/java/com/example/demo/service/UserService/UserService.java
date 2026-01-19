package com.example.demo.service.UserService;

import com.example.demo.repository.Repo;
import com.example.demo.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private Repo repo;

    public void createUser(String name, String id) {
        User user = new User(name, id);
        repo.save(user);
    }
    public User getUserById(String id) {
        return repo.findById(id).orElse(null);
    }
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
