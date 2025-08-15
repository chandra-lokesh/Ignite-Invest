package com.personalproject.controller;

import com.personalproject.entity.InterestEntity;
import com.personalproject.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/interests")
public class InterestController{

    @Autowired
    InterestService interestService;

    @PostMapping
    InterestEntity createInterest(@RequestBody InterestEntity interestEntity){
        return interestService.createInterest(interestEntity);
    }

    @GetMapping("/sent")
    List<InterestEntity> getSentInterests(@RequestHeader("Authorization") String authHeader){
        return interestService.getSentInterests(authHeader);
    }

    @GetMapping("/received")
    List<InterestEntity> getReceivedInterests(@RequestHeader("Authorization") String authHeader){
        return interestService.getReceivedInterests(authHeader);
    }

}
