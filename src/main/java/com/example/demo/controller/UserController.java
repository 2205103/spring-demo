package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AppUser;
import com.example.demo.service.UserService;
import com.example.demo.AppUserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public AppUser create(@RequestBody AppUser user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<AppUserDTO> getAll() {
        return service.getAllUsers()
                    .stream()
                    .map(user -> new AppUserDTO(
                            user.getId(),
                        "Hi (Kire Marufff)" + user.getName(),
                        "Here is your email: " + user.getEmail()))
                  .toList();
    }

}
