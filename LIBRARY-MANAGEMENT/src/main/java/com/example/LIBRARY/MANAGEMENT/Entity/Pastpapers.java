package com.example.LIBRARY.MANAGEMENT.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Pastpapers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paperId;
    private String subject;
    private int year;
    private String totalPaper;
    private String status;
}
