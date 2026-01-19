package com.example.demo.service.UserService;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.service.User;

@Service
public class UserService {
    
    // Temporary in-memory storage
    private final Map<String, User> userStore = new HashMap<>();
    
    public User createUser(String name, String id) {
        User user = new User(name, id);
        userStore.put(id, user);  // Store user by ID
        return user;
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }
    
    public User getUserById(String id) {
        return userStore.get(id);  // Returns null if not found
    }
}