package com.example.LIBRARY.MANAGEMENT.Service;

import com.example.LIBRARY.MANAGEMENT.DTO.BooksRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.BooksRsponseDTO;
import com.example.LIBRARY.MANAGEMENT.Entity.Books;
import com.example.LIBRARY.MANAGEMENT.Repository.BookRepository;
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
@Service //sehem yoyot usipoweka autowired error on service
public class BooksService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BooksRsponseDTO bookAdd(BooksRequestDTO booksRequestDTO){
        Books books = modelMapper.map(booksRequestDTO,Books.class);
        bookRepository.save(books);
        BooksRsponseDTO booksRsponseDTO = modelMapper.map(books,BooksRsponseDTO.class);
        return booksRsponseDTO;
    }

    public List<BooksRsponseDTO> getAll(){
        BooksRsponseDTO booksRsponseDTO = null;
        List<BooksRsponseDTO> list = new ArrayList<>();
        for (Books books:bookRepository.findAll()){
            booksRsponseDTO = modelMapper.map(books,BooksRsponseDTO.class);
            list.add(booksRsponseDTO);
        }
        return list;
    }

   public BooksRsponseDTO bookEdit(int bookId, BooksRequestDTO booksRequestDTO){
       Optional<Books> books = bookRepository.findById(bookId);
       if (!books.isPresent()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
       Books books1 = modelMapper.map(booksRequestDTO,Books.class);
       books1.setBookId(bookId);
       bookRepository.save(books1);
       BooksRsponseDTO booksRsponseDTO = modelMapper.map(books1,BooksRsponseDTO.class);
       return booksRsponseDTO;
   }

   public BooksRsponseDTO getById(int bookId){
        Optional<Books> books = bookRepository.findById(bookId);
        if (!books.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BooksRsponseDTO booksRsponseDTO = modelMapper.map(books.get(),BooksRsponseDTO.class);
        return booksRsponseDTO;
   }
    public ResponseEntity deleteById(int bookId){
        Optional<Books> books = bookRepository.findById(bookId);
        if (!books.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bookRepository.delete(books.get());
//        BooksRsponseDTO booksRsponseDTO = modelMapper.map(books.get(),BooksRsponseDTO.class);
        return ResponseEntity.ok(Boolean.TRUE);
    }


    public List<BooksRsponseDTO> getByName(String bookName){
        BooksRsponseDTO booksRsponseDTO = null;
        List<BooksRsponseDTO> list = new ArrayList<>();
        for (Books books:bookRepository.findByName(bookName)){
            booksRsponseDTO = modelMapper.map(books,BooksRsponseDTO.class);
            list.add(booksRsponseDTO);
        }
        return list;
   }






}
