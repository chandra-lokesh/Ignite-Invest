package com.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "investor_watchlist")
public class InvestorWatchlistItem {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID investorId;
    private UUID startupId;
    private LocalDate addedOn;
}
