package com.personalproject.service;

import com.personalproject.client.StartupClient;
import com.personalproject.dto.StartupDto;
import com.personalproject.entity.StartupFavoritesItem;
import com.personalproject.repo.StartupFavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class StartupFavoritesService {

    @Autowired
    StartupFavoritesRepository favoritesRepo;

    @Autowired
    StartupClient startupClient;

    public StartupFavoritesItem addToFavorites(String authHeader, UUID investorId) {
        StartupDto startupDto = startupClient.getMyProfile(authHeader);
        StartupFavoritesItem newFavoriteItem = new StartupFavoritesItem();
        newFavoriteItem.setStartupId(startupDto.getId());
        newFavoriteItem.setInvestorId(investorId);
        newFavoriteItem.setAddedOn(LocalDate.now());
        return favoritesRepo.save(newFavoriteItem);
    }

    public void removeFromFavorites(String authHeader, UUID investorId) {
        StartupDto startupDto = startupClient.getMyProfile(authHeader);
        favoritesRepo.deleteByStartupIdAndInvestorId(startupDto.getId(), investorId);
    }

    public List<StartupFavoritesItem> getFavorites() {
        return favoritesRepo.findAll();
    }
}
