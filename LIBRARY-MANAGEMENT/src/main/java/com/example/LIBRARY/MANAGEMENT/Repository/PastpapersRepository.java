package com.example.LIBRARY.MANAGEMENT.Repository;

import com.example.LIBRARY.MANAGEMENT.Entity.Books;
import com.example.LIBRARY.MANAGEMENT.Entity.Pastpapers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PastpapersRepository extends JpaRepository<Pastpapers,Integer> {
    @Query(value = "SELECT * from pastpapers where subject LIKE ?1%",nativeQuery = true)
    List<Pastpapers> findByName(String subject);
}
