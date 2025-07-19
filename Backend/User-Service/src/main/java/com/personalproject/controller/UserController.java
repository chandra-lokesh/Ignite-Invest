package com.personalproject.controller;

import com.personalproject.entity.UserEntity;
import com.personalproject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-service")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/create-user")
    ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    @PutMapping("/update-user")
    ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity){
        return userService.updateUser(userEntity);
    }

    @GetMapping("/get-all-users")
    ResponseEntity<List<UserEntity>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get-user-by-id/{id}")
    ResponseEntity<UserEntity> getUserById(@PathVariable UUID id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete-user/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable UUID id){
        return userService.deleteUser(id);
    }
}
