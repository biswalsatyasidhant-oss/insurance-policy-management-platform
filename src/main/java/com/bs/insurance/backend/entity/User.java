package com.bs.insurance.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @ManyToOne
    @JoinColumn(name = "role_id")
    Long id;
    String firstName;
    String lastName;
    String email;
    String Phone;
    String password;
    String status;
    String role;


}
