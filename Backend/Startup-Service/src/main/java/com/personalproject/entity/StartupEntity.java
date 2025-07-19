package com.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class StartupEntity {

    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private UUID userId;

    private String startupName;
    private String description;
    private String stage;
    private String website;
    private String industry;
    private String location;
    private BigDecimal fundingNeeded;
    private BigDecimal revenue;
}
