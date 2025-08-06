package com.personalproject.service;

import com.personalproject.client.InvestorClient;
import com.personalproject.client.StartupClient;
import com.personalproject.dto.InvestorDto;
import com.personalproject.entity.Investment;
import com.personalproject.exceptions.InvestorNotFound;
import com.personalproject.exceptions.StartupNotFound;
import com.personalproject.repo.InvestmentRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class InvestmentService {

    @Autowired
    InvestmentRepository investmentRepository;

    @Autowired
    StartupClient startupClient;

    @Autowired
    InvestorClient investorClient;

    public Investment createInvestment(Investment investment) {
        try {
            startupClient.getStartupById(investment.getStartupId());
        } catch (FeignException.InternalServerError e) {
            throw new StartupNotFound("Startup with ID: " + investment.getStartupId() + " not found.");
        }

        try {
            investorClient.getInvestorById(investment.getInvestorId());
        } catch (FeignException.InternalServerError e) {
            throw new InvestorNotFound("Investor with ID: " + investment.getInvestorId() + " not found.");
        }

        investment.setDateOfInvestment(LocalDate.now());
        return investmentRepository.save(investment);
    }

    public List<UUID> getInvestors(UUID id) {
        return investmentRepository.findInvestorByStartupId(id);
    }

    public List<UUID> getStartups(UUID id) {
        return investmentRepository.findStartupByInvestorId(id);
    }
}
