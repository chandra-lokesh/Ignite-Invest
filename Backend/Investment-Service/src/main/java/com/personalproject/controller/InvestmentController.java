package com.personalproject.controller;

import com.personalproject.dto.InvestorDto;
import com.personalproject.dto.StartupDto;
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

    @GetMapping("/startup/{startupId}")
    List<InvestorDto> getInvestorByStartupId(@PathVariable UUID startupId){
        return investmentService.getInvestorByStartupId(startupId);
    }

    @GetMapping("/investor/{investorId}")
    List<StartupDto> getStartupByInvestorId(@PathVariable UUID investorId){
        return investmentService.getStartupByInvestorId(investorId);
    }
}
