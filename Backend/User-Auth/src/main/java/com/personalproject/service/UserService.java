package com.personalproject.service;

import com.personalproject.dto.MyUserDto;
import com.personalproject.model.MyUser;
import com.personalproject.model.UserPrinciple;
import com.personalproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public MyUser registerUser(MyUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(MyUser user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getEmail());
        return "Failure";
    }

    public MyUserDto getCurrentUserProfile(String authHeader) {
        String token = authHeader.substring(7);
        String email = jwtService.extractEmail(token);
        UserPrinciple userPrinciple =(UserPrinciple) userDetailsService.loadUserByUsername(email);
        MyUserDto userDto = new MyUserDto();
        userDto.setId(userPrinciple.getId());
        userDto.setEmail(userPrinciple.getUsername());
        userDto.setRole(userPrinciple.getRole());
        return userDto;
    }

    public Optional<MyUser> getUserById(UUID id) {
        return userRepository.findById(id);
    }
}
