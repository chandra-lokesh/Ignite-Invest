package com.personalproject.controller;

import com.personalproject.dto.UserDto;
import com.personalproject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/get-user-by-id/{id}")
    ResponseEntity<UserDto> getUserById(@PathVariable UUID id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete-user/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable UUID id){
        return userService.deleteUser(id);
    }
}
