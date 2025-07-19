package com.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalproject.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private String name;
    private String email;
    private String password;
    private UserRole userRole;

    @CreationTimestamp
    private ZonedDateTime createdAt;

}
