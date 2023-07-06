package com.example.LIBRARY.MANAGEMENT.DTO;

import lombok.Data;

@Data

public class PastpapersResponseDTO {
    private int paperId;
    private String subject;
    private int year;
    private String totalPaper;
    private String status;
}
