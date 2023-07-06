package com.example.LIBRARY.MANAGEMENT.DTO;

import lombok.Data;

@Data
public class BooksRequestDTO {
    private String bookName;
    private String bookAuthor;
    private String bookTitle;
    private int year;
    private String bookPublisher;
    private String subject;
    private int totalBook;
    private String status;
}
