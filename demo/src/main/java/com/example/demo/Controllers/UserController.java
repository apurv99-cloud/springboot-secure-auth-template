package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.User;
import com.example.demo.Service.UserService;

@RestController
public class UserController {
    private UserService service;
    @PostMapping("register")
    public User register(@RequestBody User user) {
        return service.saveUser(user);
    }

}
