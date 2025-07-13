package com.personalproject.controller;

import com.personalproject.dto.UserDto;
import com.personalproject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-service/")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/create-user/")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/update-user/")
    ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @GetMapping("/get-all-users/")
    ResponseEntity<List<UserDto>> getAllUsers(){
        return userService.getAllUsers();
    }
}
