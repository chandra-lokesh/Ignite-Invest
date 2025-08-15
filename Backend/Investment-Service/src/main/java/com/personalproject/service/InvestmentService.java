package com.personalproject.service;

import com.personalproject.client.InvestorClient;
import com.personalproject.client.StartupClient;
import com.personalproject.dto.InvestorDto;
import com.personalproject.dto.StartupDto;
import com.personalproject.entity.Investment;
import com.personalproject.exceptions.InvestorNotFound;
import com.personalproject.exceptions.StartupNotFound;
import com.personalproject.repo.InvestmentRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<InvestorDto> getInvestorByStartupId(UUID startupId) {
        List<UUID> investorsIdList = investmentRepository.findInvestorByStartupId(startupId);
        List<InvestorDto> investorsList = new ArrayList<>();
        for(UUID i: investorsIdList){
            InvestorDto investor = investorClient.getInvestorById(i);
            investor.setId(i);
            investorsList.add(investor);
        }
        return investorsList;
    }

    public List<StartupDto> getStartupByInvestorId(UUID investorId) {
        List<UUID> startupsIdList = investmentRepository.findStartupByInvestorId(investorId);
        List<StartupDto> startupsList = new ArrayList<>();
        for(UUID i: startupsIdList){
            StartupDto startup = startupClient.getStartupById(i);
            startup.setId(i);
            startupsList.add(startup);
        }
        return startupsList;
    }
}
