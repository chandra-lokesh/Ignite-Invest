package com.personalproject.repo;

import com.personalproject.dto.InvestorDto;
import com.personalproject.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, UUID> {

    @Query("select investorId from Investment where startupId = :id")
    List<UUID> findInvestorByStartupId(@Param("id")UUID id);

    @Query("select startupId from Investment where investorId = :id")
    List<UUID> findStartupByInvestorId(@Param("id")UUID id);
}
