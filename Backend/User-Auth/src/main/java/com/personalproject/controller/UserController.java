package com.personalproject.controller;

import com.personalproject.dto.MyUserDto;
import com.personalproject.model.MyUser;
import com.personalproject.repo.UserRepository;
import com.personalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
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

    @GetMapping("/me")
    public MyUserDto getCurrentUserProfile(@RequestHeader("Authorization") String authHeader){
        return userService.getCurrentUserProfile(authHeader);
    }

}
