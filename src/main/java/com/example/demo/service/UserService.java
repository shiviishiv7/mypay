package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<?> getUserById(int id) throws UserNotFound {
        boolean existsById = userRepository.existsById(id);
        if(!existsById)throw new UserNotFound("User not found "+id);
        User user = userRepository.findById(id).orElse(null);
        if(user==null)throw new UserNotFound("User not found "+id);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<?> updateUser(UserDto userDto, int id) throws UserNotFound {
        boolean existsById = userRepository.existsById(id);
        if(!existsById)throw new UserNotFound("User not found "+id);
        User user = userRepository.findById(id).orElseGet(null);
        if(user==null)throw new UserNotFound("User not found "+id);
        user.setBase(userDto.getBase());
        user.setWlb(userDto.getWlb());
        user.setQuestion(userDto.getQuestion());
        user.setCompanyname(userDto.getCompanyname());
        user.setCtc(userDto.getCtc());
        user.setEmail(userDto.getEmail());
        user.setTitle(userDto.getTitle());
        user.setYoe(userDto.getYoe());
        user.setCityname(userDto.getCityname());
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> addUser(UserDto userDto){
        User user = new User();
        user.setBase(userDto.getBase());
        user.setCompanyname(userDto.getCompanyname());
        user.setCtc(userDto.getCtc());
        user.setEmail(userDto.getEmail());
        user.setTitle(userDto.getTitle());
        user.setYoe(userDto.getYoe());

        user.setWlb(userDto.getWlb());
        user.setQuestion(userDto.getQuestion());
        user.setCityname(userDto.getCityname());
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }

    public ResponseEntity<?>deleteUser(int id) throws UserNotFound {
        boolean existsById = userRepository.existsById(id);
        if(!existsById)throw new UserNotFound("User not found "+id);
        userRepository.deleteById(id);
        Map<String,String>map = new HashMap<>();
        map.put("message","Deleted");
        return ResponseEntity.ok(map);
    }

    public ResponseEntity<?> getUserByCompanyName(String companyName) {
        List<User> user = userRepository.findByCompanyname(companyName);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> getUserByCityName(String zipcode) {
        List<User> byZipCode = userRepository.findByCityname(zipcode);
        return ResponseEntity.ok(byZipCode);
    }
    public ResponseEntity<?> getUserByTitle(String title) {
        List<User> byZipCode = userRepository.findByTitle(title);
        return ResponseEntity.ok(byZipCode);
    }
    public ResponseEntity<?> getUserByEmail(String email) {
        List<User> byZipCode = userRepository.findByTitle(email);
        return ResponseEntity.ok(byZipCode);
    }
}
