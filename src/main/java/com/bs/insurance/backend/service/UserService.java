package com.bs.insurance.backend.service;

import com.bs.insurance.backend.dto.RoleRequestDTO;
import com.bs.insurance.backend.dto.UserRequestDTO;
import com.bs.insurance.backend.dto.UserResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {


    UserResponseDTO createUser(@Valid UserRequestDTO request);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO updateUser(UserRequestDTO request);

    void deleteUser(Long id);
}
