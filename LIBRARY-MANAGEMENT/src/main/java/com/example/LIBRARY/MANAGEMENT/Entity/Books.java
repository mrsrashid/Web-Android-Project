package com.example.LIBRARY.MANAGEMENT.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data //from lommbok
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookTitle;
    private int year;
    private String bookPublisher;
    private String subject;
    private int totalBook;
    private String status;
}

