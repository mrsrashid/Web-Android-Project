package com.example.LIBRARY.MANAGEMENT.Service;

import com.example.LIBRARY.MANAGEMENT.DTO.BooksRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.BooksRsponseDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.PastpapersRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.PastpapersResponseDTO;
import com.example.LIBRARY.MANAGEMENT.Entity.Books;
import com.example.LIBRARY.MANAGEMENT.Entity.Pastpapers;
import com.example.LIBRARY.MANAGEMENT.Entity.Users;
import com.example.LIBRARY.MANAGEMENT.Repository.PastpapersRepository;
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
public class PastpapersService {
    private final PastpapersRepository pastpapersRepository;
    private final ModelMapper modelMapper;

    public PastpapersResponseDTO paperAdd(PastpapersRequestDTO pastpapersRequestDTO){
        Pastpapers pastpapers = modelMapper.map(pastpapersRequestDTO,Pastpapers.class);
        pastpapersRepository.save(pastpapers);
        PastpapersResponseDTO pastpapersResponseDTO = modelMapper.map(pastpapers,PastpapersResponseDTO.class);
        return pastpapersResponseDTO;
    }

    public List<PastpapersResponseDTO> getAll(){
        PastpapersResponseDTO pastpapersResponseDTO = null;
        List<PastpapersResponseDTO> list = new ArrayList<>();
        for (Pastpapers pastpapers: pastpapersRepository.findAll()){
            pastpapersResponseDTO = modelMapper.map(pastpapers,PastpapersResponseDTO.class);
            list.add(pastpapersResponseDTO);
        }
        return list;
}

    public PastpapersResponseDTO paperEdit(int paperId, PastpapersRequestDTO pastpapersRequestDTO){
        Optional<Pastpapers> pastpapers = pastpapersRepository .findById(paperId);
        if (!pastpapers.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Pastpapers pastpapers1 = modelMapper.map(pastpapersRequestDTO,Pastpapers.class);
        pastpapers1.setPaperId(paperId);
        pastpapersRepository.save(pastpapers1);
       PastpapersResponseDTO pastpapersResponseDTO = modelMapper.map(pastpapers1,PastpapersResponseDTO.class);
        return pastpapersResponseDTO;
    }

    public PastpapersResponseDTO getById(int paperId){
        Optional<Pastpapers> pastpapers = pastpapersRepository.findById(paperId);
        if (!pastpapers.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PastpapersResponseDTO pastpapersResponseDTO = modelMapper.map(pastpapers.get(),PastpapersResponseDTO.class);
        return pastpapersResponseDTO;
    }

    public List<PastpapersResponseDTO> getByName(String subject){
        PastpapersResponseDTO pastpapersResponseDTO= null;
        List<PastpapersResponseDTO> list = new ArrayList<>();
        for (Pastpapers pastpapers:pastpapersRepository.findByName(subject)){
            pastpapersResponseDTO = modelMapper.map(pastpapers,PastpapersResponseDTO.class);
            list.add(pastpapersResponseDTO);
        }
        return list;
    }

    public ResponseEntity deleteById(int paperId){
        Optional<Pastpapers> pastpapers = pastpapersRepository.findById(paperId);
        if (!pastpapers.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pastpapersRepository.delete(pastpapers.get());
//        BooksRsponseDTO booksRsponseDTO = modelMapper.map(books.get(),BooksRsponseDTO.class);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
