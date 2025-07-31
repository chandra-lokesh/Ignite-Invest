package com.personalproject.controller;

import com.personalproject.model.MyUser;
import com.personalproject.repo.UserRepository;
import com.personalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    MyUser registerUser(@RequestBody MyUser user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody MyUser user){
        return userService.verify(user);
    }

}
