package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
   List<User> findByCompanyname(String name);
   List<User> findByCityname(String zipCode);
   List<User> findByTitle(String title);
   List<User> findByEmail(String email);

 }