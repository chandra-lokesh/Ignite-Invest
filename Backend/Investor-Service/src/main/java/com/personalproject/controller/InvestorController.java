package com.personalproject.controller;

import com.personalproject.entity.Investor;
import com.personalproject.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    @Autowired
    InvestorService investorService;


    @PostMapping
    public Investor createInvestor(@RequestBody Investor investor){
        return investorService.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public Investor getInvestorById(@PathVariable UUID id){
        return investorService.getInvestorById(id);
    }

    @GetMapping
    public List<Investor> getAllInvestors(){
        return investorService.getAllInvestors();
    }

//    @GetMapping("/my-profile")
//    public Startup getMyProfile(){
//
//    }

    @PutMapping("/{id}")
    public Investor updateInvestor(@PathVariable UUID id, @RequestBody Investor investor){
        return investorService.updateInvestor(id, investor);
    }


}