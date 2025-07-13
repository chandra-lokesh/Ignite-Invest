package com.personalproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-service")
public class TestController {
    @GetMapping("/hello")
    String sayHello(){
        return "Hello";
    }
}
