package com.personalproject.service;

import com.personalproject.entity.UserEntity;
import com.personalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> createUser(UserEntity userEntity) {
        UserEntity resUserEntity = userRepository.save(userEntity);
        if(resUserEntity.equals(userEntity))
            return ResponseEntity.ok(resUserEntity);
        return ResponseEntity.internalServerError().body(null);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(UserEntity userEntity) {
        UserEntity existingUser = userRepository.findByEmail(userEntity.getEmail());
        if(existingUser != null){
            existingUser.setName(userEntity.getName());
            return ResponseEntity.ok().body(userRepository.save(existingUser));
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> list = userRepository.findAll();
        System.out.println("List: " + list);
        if(!list.isEmpty())
            return ResponseEntity.ok(list);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserEntity> getUserById(UUID id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if(userEntity != null)
            return ResponseEntity.ok(userEntity);
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
