package com.bs.insurance.backend.service;

import com.bs.insurance.backend.dto.RoleRequestDTO;
import com.bs.insurance.backend.dto.RoleResponseDTO;

import java.util.List;

public interface RoleService {

    RoleResponseDTO createRole(RoleRequestDTO request);

    List<RoleResponseDTO> getAllRoles();

    RoleResponseDTO getRoleById(Long id);

    RoleResponseDTO updateRole(RoleRequestDTO request);

    void deleteRole(Long id);
}
