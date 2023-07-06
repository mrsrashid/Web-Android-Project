package com.example.LIBRARY.MANAGEMENT.DTO;

import lombok.Data;

@Data
public class PastpapersRequestDTO {
    private String subject;
    private int year;
    private String totalPaper;
    private String status;
}
