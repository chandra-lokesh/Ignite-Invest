package com.personalproject.service;

import com.personalproject.client.InvestorClient;
import com.personalproject.dto.InvestorDto;
import com.personalproject.entity.InvestorWatchlistItem;
import com.personalproject.repo.InvestorWatchlistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class InvestorWatchlistService {

    @Autowired
    InvestorWatchlistRepository investorWatchlistRepository;

    @Autowired
    InvestorClient investorClient;

    public InvestorWatchlistItem addToWatchlist(String authHeader, UUID startupId) {
        InvestorDto investorDto = investorClient.getMyProfile(authHeader);
        InvestorWatchlistItem newWatchlistItem = new InvestorWatchlistItem();
        newWatchlistItem.setInvestorId(investorDto.getId());
        newWatchlistItem.setStartupId(startupId);
        newWatchlistItem.setAddedOn(LocalDate.now());
        return investorWatchlistRepository.save(newWatchlistItem);
    }

    @Transactional
    public void removeFromWathclist(String authHeader, UUID startupId) {
        InvestorDto investorDto = investorClient.getMyProfile(authHeader);
        investorWatchlistRepository.deleteByInvestorIdAndStartupId(investorDto.getId(), startupId);
    }

    public List<InvestorWatchlistItem> getWatchlist() {
        return investorWatchlistRepository.findAll();
    }
}
