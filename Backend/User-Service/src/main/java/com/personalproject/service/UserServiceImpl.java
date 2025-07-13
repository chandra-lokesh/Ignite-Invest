package com.personalproject.service;

import com.personalproject.dto.UserDto;
import com.personalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        UserDto resUserDto = userRepository.save(userDto);
        if(resUserDto.equals(userDto))
            return ResponseEntity.ok(resUserDto);
        return ResponseEntity.internalServerError().body(null);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto) {
        UserDto resUserDto = userRepository.save(userDto);
        return ResponseEntity.ok(resUserDto);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> list = userRepository.findAll();
        if(list.size() != 0)
            return ResponseEntity.ok(list);
        return ResponseEntity.noContent().build();
    }
}
