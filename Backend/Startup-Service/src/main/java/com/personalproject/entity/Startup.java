package com.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalproject.enums.Stage;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Startup {

    @Id
    @GeneratedValue
    @JsonIgnore
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
