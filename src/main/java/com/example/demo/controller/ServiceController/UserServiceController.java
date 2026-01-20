package com.example.demo.controller.servicecontroller;  // ✅ Fixed package name

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;  // ✅ Fixed import
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.User;
import com.example.demo.service.UserService.UserService;

@RestController
@RequestMapping("/service/user")
public class UserServiceController {

    @Autowired
    private UserService userService;  //// ✅ Private access modifier

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
    @GetMapping("/initialize")
    public String initializeData() {
        userService.createUser("Sami Sarwar", "103");
        userService.createUser("Maruf Hasan Rahim", "104");
        userService.createUser("Fuad Shahriar", "164");
        return "Initial data createdddddddddddddddddd!";
    }
}