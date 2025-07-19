package com.personalproject.controller;

import com.personalproject.client.UserClient;
import com.personalproject.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class TestContoller {

    private final UserClient userClient;

    public TestContoller(UserClient userClient){
        this.userClient = userClient;
    }

    @GetMapping("/test")
    String sayHello(){
        return "hello";
    }

    @GetMapping("/getUserDto/{id}")
    UserDto getUserDto(@RequestParam UUID id){
        return userClient.getUserById(id);
    }
}
