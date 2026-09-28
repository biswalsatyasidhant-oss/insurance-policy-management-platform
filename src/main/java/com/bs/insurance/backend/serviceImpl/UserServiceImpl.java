package com.bs.insurance.backend.serviceImpl;

import com.bs.insurance.backend.dto.RoleRequestDTO;
import com.bs.insurance.backend.dto.RoleResponseDTO;
import com.bs.insurance.backend.dto.UserRequestDTO;
import com.bs.insurance.backend.dto.UserResponseDTO;
import com.bs.insurance.backend.entity.Role;
import com.bs.insurance.backend.entity.User;
import com.bs.insurance.backend.mapper.RoleMapper;
import com.bs.insurance.backend.mapper.UserMapper;
import com.bs.insurance.backend.repository.RoleRepository;
import com.bs.insurance.backend.repository.UserRepository;
import com.bs.insurance.backend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    private final RoleRepository roleRespository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRespository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRespository = roleRespository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {

//        if (userRepository.existsByEmail(request.getEmail())) {
//            /*throw new ResourceAlreadyExistsException(
//                    "Role already exists with name : " + request.getRoleName());*/
//            String s = "Role already exists with name : " + request.getRoleName();
//        }

        Role role = roleRespository.findById(dto.getRoleId())
                .orElseThrow(() ->
                        new RuntimeException("Role not found with id: " + dto.getRoleId())
                );

        User user = userMapper.toEntity(dto);
        user.setRole(role);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        List<User> userList = userRepository.findAll();
        return userMapper.toResponseDTO(userList);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        ;
        return userMapper.toResponseDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO request) {

        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User savedUser = null;
        if (user != null) {
            user.setEmail(request.getEmail());
            savedUser = userRepository.save(user);
        }
        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
