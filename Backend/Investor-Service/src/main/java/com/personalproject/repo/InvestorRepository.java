package com.personalproject.repo;

import com.personalproject.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, UUID> {
    Investor findByUserId(UUID id);
}
