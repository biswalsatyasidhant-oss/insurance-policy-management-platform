package com.bs.insurance.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RoleResponseDTO {

    Long id;
    String roleName;
    String description;
    LocalDateTime createdAt;

}
