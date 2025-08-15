package com.personalproject.client;

import com.personalproject.dto.InvestorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "INVESTOR-SERVICE", path = "/api/investors")
public interface InvestorClient {

    @GetMapping("/my-profile")
    public InvestorDto getMyProfile(@RequestHeader("Authorization") String authHeader);
}
