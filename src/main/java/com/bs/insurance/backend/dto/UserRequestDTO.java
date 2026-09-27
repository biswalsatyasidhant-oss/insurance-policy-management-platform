package com.bs.insurance.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {

    Long id;
    String firstName;
    String lastName;
    String email;
    String Phone;
    String password;
    String status;
    String role;
}
