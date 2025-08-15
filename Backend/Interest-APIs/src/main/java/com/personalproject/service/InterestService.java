package com.personalproject.service;

import com.personalproject.client.InvestorClient;
import com.personalproject.client.StartupClient;
import com.personalproject.client.UserClient;
import com.personalproject.dto.CommonDto;
import com.personalproject.dto.UserDto;
import com.personalproject.entity.InterestEntity;
import com.personalproject.repo.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestService {

    @Autowired
    InterestRepository interestRepository;

    @Autowired
    UserClient userClient;

    @Autowired
    StartupClient startupClient;

    @Autowired
    InvestorClient investorClient;

    public InterestEntity createInterest(InterestEntity interestEntity) {
        return interestRepository.save(interestEntity);
    }

    public List<InterestEntity> getSentInterests(String authHeader) {
        UserDto userDto = userClient.getCurrentUserProfile(authHeader);
        System.out.println(userDto);
        CommonDto commonDto = startupClient.getMyProfile(authHeader);
        List<InterestEntity> sentInterestList;
        if(userDto.getRole().toString().equals("STARTUP")){
            sentInterestList =  interestRepository.findByFromUserId(commonDto.getId());
        }
        else if(userDto.getRole().toString().equals("INVESTOR")){
            sentInterestList = interestRepository.find
        }
        return null;
    }

    public List<InterestEntity> getReceivedInterests(String authHeader) {
        UserDto userDto = userClient.getCurrentUserProfile(authHeader);
        System.out.println(userDto);
        if(userDto.getRole().toString().equals("STARTUP")){
            CommonDto startupDto = startupClient.getMyProfile(authHeader);
            return interestRepository.findByToUserId(startupDto.getId());
        }
        else if(userDto.getRole().toString().equals("INVESTOR")){
            CommonDto investorDto = investorClient.getMyProfile(authHeader);
            return interestRepository.findByToUserId(investorDto.getId());
        }
        return null;
    }
}
