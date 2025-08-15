package com.personalproject.repo;

import com.personalproject.entity.InterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InterestRepository extends JpaRepository<InterestEntity, UUID> {
    List<InterestEntity> findByFromUserId(UUID id);
    List<InterestEntity> findByToUserId(UUID id);
}
