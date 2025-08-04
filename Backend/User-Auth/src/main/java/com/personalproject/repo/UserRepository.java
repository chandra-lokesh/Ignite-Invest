package com.personalproject.repo;

import com.personalproject.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<MyUser, UUID> {
    MyUser findByEmail(String email);
}
