package com.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalproject.enums.Stage;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class StartUp {

    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private UUID userId;

    private String name;
    private String bio;
    private Stage stage;
    private String industryTags;
    private String location;
    private String website;
    private BigDecimal fundingNeeded;
    private BigDecimal revenue;
    private Integer roundsCompleted;
}
