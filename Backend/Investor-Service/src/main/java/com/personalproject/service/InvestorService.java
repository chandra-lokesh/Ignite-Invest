package com.personalproject.service;

import com.personalproject.client.UserClient;
import com.personalproject.dto.UserDto;
import com.personalproject.entity.Investor;
import com.personalproject.exceptions.AlreadyExistingException;
import com.personalproject.exceptions.InvestorNotFoundException;
import com.personalproject.exceptions.RoleMismatchException;
import com.personalproject.repo.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    UserClient userClient;

    public Investor createInvestor(Investor investor) {
        UUID userId = investor.getUserId();
        UserDto user = userClient.getUserById(userId);
        if(investorRepository.findByUserId(userId) == null){
            if(user.getRole().toString().equals("INVESTOR")){
                return investorRepository.save(investor);
            }
            throw new RoleMismatchException("User Role Mismatch: Expected - INVESTOR Found - " + user.getRole());
        }
        throw new AlreadyExistingException("Startup with User Id: " + userId + " is Already Existing in Database");
    }

    public Investor getInvestorById(UUID id) {
        return investorRepository.findById(id).orElseThrow(() -> new InvestorNotFoundException("Startup with Id: " + id + " Not Found !!!"));
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Investor updateInvestor(UUID id, Investor investor) {
        Investor existingInvestor = investorRepository.findById(id)
                .orElseThrow(() -> new InvestorNotFoundException("Investor with Id: " + id + " Not Found !!!"));

        if (investor.getUserId() != null)
            existingInvestor.setUserId(investor.getUserId());

        if (investor.getName() != null)
            existingInvestor.setName(investor.getName());

        if (investor.getBio() != null)
            existingInvestor.setBio(investor.getBio());

        if (investor.getInterests() != null)
            existingInvestor.setInterests(investor.getInterests());

        if (investor.getFundingRangeMin() != null)
            existingInvestor.setFundingRangeMin(investor.getFundingRangeMin());

        if (investor.getFundingRangeMax() != null)
            existingInvestor.setFundingRangeMax(investor.getFundingRangeMax());

        if (investor.getStagePreference() != null)
            existingInvestor.setStagePreference(investor.getStagePreference());

        if (investor.getLocation() != null)
            existingInvestor.setLocation(investor.getLocation());

        return investorRepository.save(existingInvestor);
    }

}
