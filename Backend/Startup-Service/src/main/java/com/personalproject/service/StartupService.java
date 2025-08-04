package com.personalproject.service;

import com.personalproject.entity.Startup;
import com.personalproject.enums.Stage;
import com.personalproject.exception.StartupNotFound;
import com.personalproject.repo.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StartupService {

    @Autowired
    StartupRepository startupRepository;

//    @Autowired
//    UserClient userClient;

    public Startup createStartup(Startup startup) {
//        UUID userId = startup.getUserId();
//        try{
//            userClient.getUserById(userId);
//        } catch (FeignException.NotFound e) {
//            throw new IllegalArgumentException("User with id " + userId + " does not exist");
//        }
        return startupRepository.save(startup);
    }

    public Startup getStartupById(UUID id) {
        return startupRepository.findById(id).orElseThrow(() -> new StartupNotFound("Startup with Id: " + id + " Not Found !!!"));
    }

    public List<Startup> getAllStartups() {
        return startupRepository.findAll();
    }

    public Startup updateStartup(UUID id, Startup startup) {
        Startup existingStartup = startupRepository.findById(id)
                .orElseThrow(() -> new StartupNotFound("Startup with Id: " + id + " Not Found !!!"));

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

}
