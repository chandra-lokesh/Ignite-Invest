package com.personalproject.service;

import com.personalproject.client.UserClient;
import com.personalproject.dto.UserDto;
import com.personalproject.entity.Startup;
import com.personalproject.exception.AlreadyExistingException;
import com.personalproject.exception.RoleMismatchException;
import com.personalproject.exception.StartupNotFoundException;
import com.personalproject.repo.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class StartupService {

    @Autowired
    StartupRepository startupRepository;

    @Autowired
    UserClient userClient;

    public Startup createStartup(Startup startup) {
        UUID userId = startup.getUserId();
        UserDto user = userClient.getUserById(userId);
        if(startupRepository.findByUserId(userId) == null){
            if(user.getRole().toString().equals("STARTUP")){
                return startupRepository.save(startup);
            }
            throw new RoleMismatchException("User Role Mismatch: Expected - STARTUP Found - " + user.getRole());
        }
        throw new AlreadyExistingException("Startup with User Id: " + userId + " is Already Existing in Database");
    }

    public Startup getStartupById(UUID id) {
        return startupRepository.findById(id).orElseThrow(() -> new StartupNotFoundException("Startup with Id: " + id + " Not Found !!!"));
    }

    public List<Startup> getAllStartups() {
        return startupRepository.findAll();
    }

    public Startup updateStartup(UUID id, Startup startup) {
        Startup existingStartup = startupRepository.findById(id)
                .orElseThrow(() -> new StartupNotFoundException("Startup with Id: " + id + " Not Found !!!"));

        if (startup.getName() != null)
            existingStartup.setName(startup.getName());

        if (startup.getBio() != null)
            existingStartup.setBio(startup.getBio());

        if (startup.getStage() != null)
            existingStartup.setStage(startup.getStage());

        if (startup.getIndustryTags() != null)
            existingStartup.setIndustryTags(startup.getIndustryTags());

        if (startup.getLocation() != null)
            existingStartup.setLocation(startup.getLocation());

        if (startup.getWebsite() != null)
            existingStartup.setWebsite(startup.getWebsite());

        if (startup.getInvestmentNeeded() != null)
            existingStartup.setInvestmentNeeded(startup.getInvestmentNeeded());

        if (startup.getRevenue() != null)
            existingStartup.setRevenue(startup.getRevenue());

        if (startup.getRoundsCompleted() != null)
            existingStartup.setRoundsCompleted(startup.getRoundsCompleted());

        return startupRepository.save(existingStartup);
    }

    public Startup getCurrentStartupProfile(String authHeader) {
        UserDto userDto = userClient.getCurrentUserProfile(authHeader);
        System.out.println(userDto);
        Startup startup = startupRepository.findByUserId(userDto.getId());
        System.out.println(startup);
        return startup;
    }
}
