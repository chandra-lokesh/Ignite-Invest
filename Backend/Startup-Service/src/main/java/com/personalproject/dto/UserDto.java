package com.personalproject.dto;

import com.personalproject.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private UserRole userRoles;
    private ZonedDateTime createdAt;
}
