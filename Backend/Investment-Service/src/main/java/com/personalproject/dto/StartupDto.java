package com.personalproject.dto;

import com.personalproject.enums.Stage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartupDto {
    private UUID id;
    private UUID userId;
    private String name;
    private String bio;
    private Stage stage;
    private List<String> industryTags;
    private String location;
    private String website;
    private BigDecimal investmentNeeded;
    private BigDecimal revenue;
    private Integer roundsCompleted;
}
