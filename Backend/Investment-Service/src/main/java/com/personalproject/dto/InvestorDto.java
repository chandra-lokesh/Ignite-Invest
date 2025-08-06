package com.personalproject.dto;

import com.personalproject.enums.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestorDto {
    private UUID id;
    private UUID userId;
    private String name;
    private String bio;
    private List<String> interests;
    private Double fundingRangeMin;
    private Double fundingRangeMax;
    private Stage stagePreference;
    private String location;
}
