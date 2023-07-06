package com.example.LIBRARY.MANAGEMENT.DTO;

import lombok.Data;

@Data
public class UsersResponseDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String gender;
    private String password;
    private String role;
}
