package com.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalproject.enums.Stage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Investor {

    @Id
    @GeneratedValue
    @JsonIgnore
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
