package com.personalproject.client;

import com.personalproject.dto.InvestorDto;
import com.personalproject.dto.StartupDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "INVESTOR-SERVICE", path = "/api/investors")
public interface InvestorClient {
    @GetMapping("/{id}")
    public InvestorDto getInvestorById(@PathVariable UUID id);
}