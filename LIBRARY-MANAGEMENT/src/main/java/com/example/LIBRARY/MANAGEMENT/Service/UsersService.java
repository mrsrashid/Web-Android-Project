package com.example.LIBRARY.MANAGEMENT.Service;

import com.example.LIBRARY.MANAGEMENT.DTO.PastpapersRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.PastpapersResponseDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.UsersRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.UsersResponseDTO;
import com.example.LIBRARY.MANAGEMENT.Entity.Books;
import com.example.LIBRARY.MANAGEMENT.Entity.Pastpapers;
import com.example.LIBRARY.MANAGEMENT.Entity.Users;
import com.example.LIBRARY.MANAGEMENT.Repository.UsersRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UsersResponseDTO userAdd(UsersRequestDTO usersRequestDTO) {
        Users users = modelMapper.map(usersRequestDTO, Users.class);
        usersRepository.save(users);
        UsersResponseDTO usersResponseDTO = modelMapper.map(users, UsersResponseDTO.class);
        return usersResponseDTO;
    }



    public List<UsersResponseDTO> getAll(){
        UsersResponseDTO usersResponseDTO = null;
        List<UsersResponseDTO> list = new ArrayList<>();
        for (Users users: usersRepository.findAll()){
            usersResponseDTO = modelMapper.map(users,UsersResponseDTO.class);
            list.add(usersResponseDTO);
        }
        return list;
    }

    public UsersResponseDTO userEdit(int userId, UsersRequestDTO usersRequestDTO){
        Optional<Users> users = usersRepository .findById(userId);
        if (!users.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Users users1 = modelMapper.map(usersRequestDTO,Users.class);
        users1.setUserId(userId);
        usersRepository.save(users1);
        UsersResponseDTO usersResponseDTO = modelMapper.map(users1,UsersResponseDTO.class);
        return usersResponseDTO;
    }

    public UsersResponseDTO getById(int userId){
        Optional<Users> users = usersRepository.findById(userId);
        if (!users.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UsersResponseDTO usersResponseDTO = modelMapper.map(users.get(),UsersResponseDTO.class);
        return usersResponseDTO;
    }

    public ResponseEntity deleteById(int userId){
        Optional<Users> users = usersRepository.findById(userId);
        if (!users.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        usersRepository.delete(users.get());
//        BooksRsponseDTO booksRsponseDTO = modelMapper.map(books.get(),BooksRsponseDTO.class);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    public Users processLogin(String username,String password){
        Optional<Users> p = usersRepository.processLogin(username, password);
        if(p.isPresent()){
            return p.get();
        }else{
            return new Users();
        }
    }
}
