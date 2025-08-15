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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "interest")
public class InterestEntity {

    @Id
    @GeneratedValue
    UUID id;
    UUID fromUserId;
    UUID toUserId;
    LocalDate timeStamp;
}
