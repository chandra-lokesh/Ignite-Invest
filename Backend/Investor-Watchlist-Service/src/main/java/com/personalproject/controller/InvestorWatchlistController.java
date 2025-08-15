package com.personalproject.controller;

import com.personalproject.entity.InvestorWatchlistItem;
import com.personalproject.service.InvestorWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/watchlist")
public class InvestorWatchlistController {

    @Autowired
    InvestorWatchlistService investorWatchlistService;

    @PostMapping("/startups/{startupId}")
    InvestorWatchlistItem addToWatchlist(@RequestHeader("Authorization") String authHeader, @PathVariable UUID startupId){
        return investorWatchlistService.addToWatchlist(authHeader, startupId);
    }

    @DeleteMapping("/startups/{startupId}")
    void removeFromWatchlist(@RequestHeader("Authorization") String authHeader, @PathVariable UUID startupId){
         investorWatchlistService.removeFromWathclist(authHeader, startupId);
    }

    @GetMapping
    List<InvestorWatchlistItem> getWatchList(){
        return investorWatchlistService.getWatchlist();
    }
}
