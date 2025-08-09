package com.personalproject.client;

import com.personalproject.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@FeignClient(name = "USER-AUTH", path = "/api/auth")
public interface UserClient {
    @GetMapping("/getUserById/{id}")
    UserDto getUserById(@PathVariable("id") UUID id);
    @GetMapping("/me")
    UserDto getCurrentUserProfile(@RequestHeader("Authorization") String authHeader);
}