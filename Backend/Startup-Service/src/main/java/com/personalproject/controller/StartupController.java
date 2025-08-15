package com.personalproject.controller;

import com.personalproject.dto.UserDto;
import com.personalproject.entity.Startup;
import com.personalproject.service.StartupService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/startups")
public class StartupController {

    @Autowired
    StartupService startUpService;

    @PostMapping
    public Startup createStartup(@RequestBody Startup startUp){
        return startUpService.createStartup(startUp);
    }

    @GetMapping("/{id}")
    public Startup getStartupById(@PathVariable UUID id){
        return startUpService.getStartupById(id);
    }

    @GetMapping
    public List<Startup> getAllStartUps(){
        return startUpService.getAllStartups();
    }

    @GetMapping("/my-profile")
    public Startup getMyProfile(@RequestHeader("Authorization") String authHeader){
        System.out.println("In Startup controller inside getMyProfile() " + LocalDateTime.now());
        return startUpService.getCurrentStartupProfile(authHeader);
    }

    @PutMapping("/{id}")
    public Startup updateStartup(@PathVariable UUID id, @RequestBody Startup startup){
        return startUpService.updateStartup(id, startup);
    }


}
