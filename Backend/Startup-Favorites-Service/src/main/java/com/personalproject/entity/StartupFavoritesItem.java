package com.personalproject.entity;

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
@Table(name = "startup_favorite")
public class StartupFavoritesItem {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID startupId;
    private UUID investorId;
    private LocalDate addedOn;
}