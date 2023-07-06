package com.example.LIBRARY.MANAGEMENT.Repository;

import com.example.LIBRARY.MANAGEMENT.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Books,Integer> {
    @Query(value = "SELECT * from books where book_name LIKE ?1%",nativeQuery = true)
    List<Books> findByName(String bookName);
}

