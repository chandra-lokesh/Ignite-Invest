package com.personalproject.client;

import com.personalproject.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "USER-SERVICE", path = "/api/user-service")
public interface UserClient {
    @GetMapping("/get-user-by-id/{id}")
    UserDto getUserById(@PathVariable("id") UUID id);
}
