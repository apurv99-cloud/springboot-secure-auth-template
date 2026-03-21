package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String greet(HttpServletRequest req) {
        return "Hello World" + req.getSession().getId();
    }

    @GetMapping("about")
    public String hell(HttpServletRequest req) {
        return "Apurv" + req.getSession().getId();
    }
}