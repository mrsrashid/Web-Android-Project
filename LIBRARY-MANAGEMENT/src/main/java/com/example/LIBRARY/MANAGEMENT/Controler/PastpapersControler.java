package com.example.LIBRARY.MANAGEMENT.Controler;

import com.example.LIBRARY.MANAGEMENT.DTO.BooksRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.PastpapersRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.PastpapersResponseDTO;
import com.example.LIBRARY.MANAGEMENT.Service.PastpapersService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("papers")
@Data
@CrossOrigin
@RestController
public class PastpapersControler {
    @Autowired
    private final PastpapersService pastpapersService;

    @RequestMapping(value = "/paperAdd/",method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody PastpapersRequestDTO pastpapersRequestDTO){
        return ResponseEntity.ok(pastpapersService.paperAdd(pastpapersRequestDTO));
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(pastpapersService.getAll());
    }

    @RequestMapping(value = "/{paperId}/", method = RequestMethod.PUT)
    public ResponseEntity edit(@PathVariable("paperId") int paperId, @RequestBody PastpapersRequestDTO pastpapersRequestDTO){
        return ResponseEntity.ok(pastpapersService.paperEdit(paperId,pastpapersRequestDTO));
    }

    @RequestMapping(value = "/{paperId}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("paperId") int paperId){
        return  ResponseEntity.ok(pastpapersService.getById(paperId));
    }

    @RequestMapping(value = "getPaperSubject/{subject}",method = RequestMethod.GET)
    public ResponseEntity getBookByName(@PathVariable("subject") String subject){
        return ResponseEntity.ok(pastpapersService.getByName(subject));
    }

    @RequestMapping(value = "/{paperId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("paperId") int paperId){
        return  ResponseEntity.ok(pastpapersService.deleteById(paperId));
    }
}
