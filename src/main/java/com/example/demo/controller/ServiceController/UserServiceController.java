package com.example.demo.controller.servicecontroller;  // ✅ Fixed package name

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.User;
import com.example.demo.service.UserService.UserService;  // ✅ Fixed import

import java.util.List;

@RestController
@RequestMapping("/service/user")
public class UserServiceController {

    @Autowired
    private UserService userService;  // ✅ Private access modifier

    @GetMapping("/")
    public String serviceHome() {
        return "Welcome to the User Service Controller!";
    }

    // ✅ Create a separate endpoint to add users
    @PostMapping("/add")
    public User addUser(@RequestParam String name, 
                       @RequestParam String id) {
        return userService.createUser(name, id);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        // ❌ REMOVE THIS: Don't create user when fetching all users
        // userService.createUser("Sami Sarwar", "2205103");
        
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // ✅ Initialize with some data (optional)
    @PostMapping("/initialize")
    public String initializeData() {
        userService.createUser("Sami Sarwar", "2205103");
        userService.createUser("John Doe", "2205104");
        userService.createUser("Jane Smith", "2205105");
        return "Initial data created!";
    }
}