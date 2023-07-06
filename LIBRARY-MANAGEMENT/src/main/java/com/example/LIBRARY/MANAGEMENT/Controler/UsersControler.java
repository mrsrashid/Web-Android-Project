package com.example.LIBRARY.MANAGEMENT.Controler;

import com.example.LIBRARY.MANAGEMENT.DTO.PastpapersRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.UsersRequestDTO;
import com.example.LIBRARY.MANAGEMENT.DTO.UsersResponseDTO;
import com.example.LIBRARY.MANAGEMENT.Entity.Users;
import com.example.LIBRARY.MANAGEMENT.Service.UsersService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@Data
@CrossOrigin
@RestController
public class UsersControler {
    @Autowired
    private final UsersService usersService;


    @RequestMapping(value = "/userAdd/",method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody UsersRequestDTO usersRequestDTO){
        return ResponseEntity.ok(usersService.userAdd(usersRequestDTO));
    }
    @GetMapping("/process_login/{username}/{password}")
    public Users processLogin(@PathVariable("username") String username, @PathVariable("password") String password){
        return usersService.processLogin(username, password);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(usersService.getAll());
    }

    @RequestMapping(value = "/{userId}/", method = RequestMethod.PUT)
    public ResponseEntity edit(@PathVariable("userId") int userId, @RequestBody UsersRequestDTO usersRequestDTO){
        return ResponseEntity.ok(usersService.userEdit(userId,usersRequestDTO));
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("userId") int userId){
        return  ResponseEntity.ok(usersService.getById(userId));
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("userId") int userId){
        return  ResponseEntity.ok(usersService.deleteById(userId));
    }
}
