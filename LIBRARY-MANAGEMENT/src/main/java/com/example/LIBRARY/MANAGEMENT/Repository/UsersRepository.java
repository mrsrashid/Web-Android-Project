package com.example.LIBRARY.MANAGEMENT.Repository;

import com.example.LIBRARY.MANAGEMENT.DTO.UsersResponseDTO;
import com.example.LIBRARY.MANAGEMENT.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    @Query(value = "SELECT * from users where email = ?1 and password = ?2",nativeQuery = true)
    Optional<Users> processLogin(String email,String password);
}
