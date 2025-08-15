package com.personalproject.client;

import com.personalproject.dto.CommonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "STARTUP-SERVICE", path = "/api/startups")
public interface StartupClient {

    @GetMapping("/my-profile")
    public CommonDto getMyProfile(@RequestHeader("Authorization") String authHeader);
}