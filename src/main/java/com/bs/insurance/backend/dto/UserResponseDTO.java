package com.bs.insurance.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    Long id;
    String firstName;
    String lastName;
    String email;
    String Phone;
    String status;
    String role;
}
