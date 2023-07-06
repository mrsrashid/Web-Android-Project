package com.example.LIBRARY.MANAGEMENT.DTO;

import lombok.Data;

@Data
public class UsersRequestDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String gender;
    private String password;
    private String role;
}
