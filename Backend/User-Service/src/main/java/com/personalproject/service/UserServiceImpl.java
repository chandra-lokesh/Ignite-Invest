package com.personalproject.service;

import com.personalproject.dto.UserDto;
import com.personalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        UserDto existingUser = userRepository.findByEmail(userDto.getEmail());
        if(existingUser != null){
            existingUser.setName(userDto.getName());
            return ResponseEntity.ok().body(userRepository.save(existingUser));
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> list = userRepository.findAll();
        if(!list.isEmpty())
            return ResponseEntity.ok(list);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDto> getUserById(UUID id) {
        UserDto userDto = userRepository.findById(id).orElse(null);
        if(userDto != null)
            return ResponseEntity.ok(userDto);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<String> deleteUser(UUID id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok("Deleted Succesfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with Id " + id + " Not Found");
    }

}
