package com.personalproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalproject.roles.UserRoles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class UserDto {

    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private String name;
    private String email;
    private String password;
    private UserRoles userRoles;

    @CreationTimestamp
    private ZonedDateTime createdAt;

}
