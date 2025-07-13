package com.personalproject.service;

import com.personalproject.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<UserDto> createUser(UserDto userDto);
    public ResponseEntity<UserDto> updateUser(UserDto userDto);
    public ResponseEntity<List<UserDto>> getAllUsers();
}
