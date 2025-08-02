package com.personalproject.service;

import com.personalproject.model.MyUser;
import com.personalproject.model.UserPrinciple;
import com.personalproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MyUser user = userRepository.findByEmail(email);
        System.out.println("EMAIL ======== " + email);
        if(user == null){
            System.out.println("User Not Found!!!");
            throw new UsernameNotFoundException("User Not Found!!!");
        }
        return new UserPrinciple(user);
    }
}