package com.personalproject.controller;

import com.personalproject.dto.InvestorDto;
import com.personalproject.entity.Investment;
import com.personalproject.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;

    @PostMapping
    Investment createInvestment(@RequestBody Investment investment){
        return investmentService.createInvestment(investment);
    }

    @GetMapping("/startup/{id}")
    List<UUID> getInvestors(@PathVariable UUID id){
        return investmentService.getInvestors(id);
    }

    @GetMapping("/investor/{id}")
    List<UUID> getStartup(@PathVariable UUID id){
        return investmentService.getStartups(id);
    }
}
