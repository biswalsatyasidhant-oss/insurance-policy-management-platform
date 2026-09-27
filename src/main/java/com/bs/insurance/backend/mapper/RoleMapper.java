package com.bs.insurance.backend.mapper;

import com.bs.insurance.backend.dto.RoleRequestDTO;
import com.bs.insurance.backend.dto.RoleResponseDTO;
import com.bs.insurance.backend.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleMapper {

    public Role toEntity(RoleRequestDTO dto) {

        Role role = new Role();

        role.setRoleName(dto.getRoleName());
        role.setDescription(dto.getDescription());

        return role;
    }

    public RoleResponseDTO toResponseDTO(Role role) {

        RoleResponseDTO dto = new RoleResponseDTO();

        dto.setId(role.getId());
        dto.setRoleName(role.getRoleName());
        dto.setDescription(role.getDescription());
        dto.setCreatedAt(role.getCreatedAt());

        return dto;
    }

    public List<RoleResponseDTO> toResponseDTO(List<Role> roles) {

        return roles.stream()
                .map(this::toResponseDTO)
                .toList();
    }

}
