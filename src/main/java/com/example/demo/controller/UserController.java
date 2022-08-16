package com.example.demo.controller;


import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFound;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getuserById(@PathVariable("id") int id) throws UserNotFound {
        return userService.getUserById(id);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAlluser() {
        return userService.getAllUser();
    }
    @PostMapping("/add")
    public ResponseEntity<?> adduser(@Valid @RequestBody UserDto userDto) {
        System.out.println(userDto);
        return userService.addUser(userDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateuserById(@Valid @RequestBody UserDto userDto,@PathVariable int id) throws UserNotFound {
        return userService.updateUser(userDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) throws UserNotFound {
            return userService.deleteUser(id);
    }
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam Map<String,String> params) {

        if(params.containsKey("companyname")){
            System.out.println("company name");
            return userService.getUserByCompanyName(params.get("companyname"));
        }else if(params.containsKey("cityname")){
            System.out.println("cityname");
            return userService.getUserByCityName(params.get("cityname"));
        }else if(params.containsKey("title")){
            System.out.println("title");
            return userService.getUserByTitle(params.get("title"));
        }else if(params.containsKey("email")){
            System.out.println("email");
            return userService.getUserByEmail(params.get("email"));
        } else return userService.getAllUser();


    }


}
