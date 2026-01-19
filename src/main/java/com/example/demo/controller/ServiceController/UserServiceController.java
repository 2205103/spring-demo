package com.example.demo.controller.ServiceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.User;
import com.example.demo.service.UserService.UserService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/service/user")
public class UserServiceController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public String serviceHome() {
        return "Welcome to the User Service Controller!";
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create/{name}/{id}")
    public void createUser(@PathVariable String name, @PathVariable String id) {
        userService.createUser(name, id);
    }
}
