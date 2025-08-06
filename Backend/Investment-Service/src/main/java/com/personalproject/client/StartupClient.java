package com.personalproject.client;


import com.personalproject.dto.StartupDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "STARTUP-SERVICE", path = "/api/startups")
public interface StartupClient {
    @GetMapping("/{id}")
    public StartupDto getStartupById(@PathVariable UUID id);
}
