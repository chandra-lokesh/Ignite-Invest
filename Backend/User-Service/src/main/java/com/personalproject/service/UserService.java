package com.personalproject.service;

import com.personalproject.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public ResponseEntity<UserEntity> createUser(UserEntity userEntity);
    public ResponseEntity<UserEntity> updateUser(UserEntity userEntity);
    public ResponseEntity<List<UserEntity>> getAllUsers();
    public ResponseEntity<UserEntity> getUserById(UUID id);
    public ResponseEntity<String> deleteUser(UUID id);
}
