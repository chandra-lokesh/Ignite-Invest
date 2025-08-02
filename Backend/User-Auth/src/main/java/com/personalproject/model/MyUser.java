package com.personalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalproject.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {

    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;
    private String email;
    private String password;
    private Role role;
}
