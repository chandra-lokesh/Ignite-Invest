package com.personalproject.repo;

import com.personalproject.entity.StartupFavoritesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StartupFavoritesRepository extends JpaRepository<StartupFavoritesItem, UUID> {

    void deleteByStartupIdAndInvestorId(UUID startupId, UUID investorId);
}
