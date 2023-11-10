package com.example.JWT.service;


import com.example.JWT.model.User;
import com.example.JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder  passwordEncoder;




 public List<User> getUser(){
     return userRepository.findAll();
 }

 public User createUser(User user){
     user.setUserId(UUID.randomUUID().toString());
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     user.setEmail(user.getEmail());

     return userRepository.save(user);
 }


}
