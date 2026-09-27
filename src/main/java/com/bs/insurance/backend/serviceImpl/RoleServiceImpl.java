package com.bs.insurance.backend.serviceImpl;

import com.bs.insurance.backend.dto.RoleRequestDTO;
import com.bs.insurance.backend.dto.RoleResponseDTO;
import com.bs.insurance.backend.entity.Role;
import com.bs.insurance.backend.mapper.RoleMapper;
import com.bs.insurance.backend.repository.RoleRepository;
import com.bs.insurance.backend.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO request) {

        if (roleRepository.existsByRoleName(request.getRoleName())) {
            /*throw new ResourceAlreadyExistsException(
                    "Role already exists with name : " + request.getRoleName());*/
            String s = "Role already exists with name : " + request.getRoleName();
        }

        Role role = roleMapper.toEntity(request);
        Role savedRole = roleRepository.save(role);
        return roleMapper.toResponseDTO(savedRole);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {

        List<Role> roles = roleRepository.findAll();
        return roleMapper.toResponseDTO(roles);
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return roleMapper.toResponseDTO(role);
    }

    @Override
    public RoleResponseDTO updateRole(RoleRequestDTO request) {

        Role role = roleRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Role savedRole = null;
        if (role != null) {
            role.setDescription(request.getDescription());
            savedRole = roleRepository.save(role);
        }
        return roleMapper.toResponseDTO(savedRole);
    }

    @Override
    public void deleteRole(Long id) {

        roleRepository.deleteById(id);
    }

}
