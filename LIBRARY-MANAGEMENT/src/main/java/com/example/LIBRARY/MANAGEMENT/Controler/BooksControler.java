package com.example.LIBRARY.MANAGEMENT.Controler;

import com.example.LIBRARY.MANAGEMENT.DTO.BooksRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.BooksRsponseDTO;
import com.example.LIBRARY.MANAGEMENT.Service.BooksService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//end point
@RequestMapping("books") //path that we kept to the environment
@Data
@CrossOrigin //if you dont use sometomes browser give you error bcsof it firewall
@RestController
public class BooksControler {
    @Autowired
    private final BooksService booksService;


    @RequestMapping(value = "/bookAdd/",method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody BooksRequestDTO booksRequestDTO){
        return ResponseEntity.ok(booksService.bookAdd(booksRequestDTO));
    }

@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(booksService.getAll());
}

@RequestMapping(value = "/{bookId}/", method = RequestMethod.PUT)
    public ResponseEntity edit(@PathVariable("bookId") int bookId,@RequestBody BooksRequestDTO booksRequestDTO){
        return ResponseEntity.ok(booksService.bookEdit(bookId,booksRequestDTO));
    }

    @RequestMapping(value = "/{bookId}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("bookId") int bookId){
        return  ResponseEntity.ok(booksService.getById(bookId));
    }

    @RequestMapping(value = "/{bookId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("bookId") int bookId){
        return  ResponseEntity.ok(booksService.deleteById(bookId));
    }

    @RequestMapping(value = "getBookName/{bookName}",method = RequestMethod.GET)
    public ResponseEntity getBookByName(@PathVariable("bookName") String bookName){
        return ResponseEntity.ok(booksService.getByName(bookName));
    }

}

