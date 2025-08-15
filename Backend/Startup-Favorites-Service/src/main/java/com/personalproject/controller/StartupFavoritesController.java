package com.personalproject.controller;

import com.personalproject.entity.StartupFavoritesItem;
import com.personalproject.service.StartupFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/favorites")
public class StartupFavoritesController {

    @Autowired
    StartupFavoritesService startupFavoritesService;

    @PostMapping("/investors/{investorId}")
    StartupFavoritesItem addToFavorites(@RequestHeader("Authorization") String authHeader, @PathVariable UUID investorId){
        return startupFavoritesService.addToFavorites(authHeader, investorId);
    }

    @DeleteMapping("/investors/{investorId}")
    void removeFromFavorites(@RequestHeader("Authorization") String authHeader, @PathVariable UUID investorId){
        startupFavoritesService.removeFromFavorites(authHeader, investorId);
    }

    @GetMapping
    List<StartupFavoritesItem> getFavorites(){
        return startupFavoritesService.getFavorites();
    }

}
