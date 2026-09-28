package com.bs.insurance.backend.mapper;

import com.bs.insurance.backend.dto.RoleRequestDTO;
import com.bs.insurance.backend.dto.RoleResponseDTO;
import com.bs.insurance.backend.dto.UserRequestDTO;
import com.bs.insurance.backend.dto.UserResponseDTO;
import com.bs.insurance.backend.entity.Role;
import com.bs.insurance.backend.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {

        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setStatus(dto.getStatus());

        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setStatus(user.getStatus());

        return userResponseDTO;
    }

    public List<UserResponseDTO> toResponseDTO(List<User> users) {

        return users.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
