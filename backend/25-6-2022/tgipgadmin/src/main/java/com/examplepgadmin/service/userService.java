package com.examplepgadmin.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplepgadmin.dto.userdto;
import com.examplepgadmin.model.user;
import com.examplepgadmin.repository.UserRepository;
import java.util.Date;
@Service
public class userService {
    @Autowired
    private UserRepository userRepository;
    public  List<user> getAllUser(){
        return userRepository.findAll();
     
    } 
    public user createUser(userdto userdto){
        user users=new user(
        UUID.randomUUID().toString(),
        userdto.getFirstName(),
        userdto.getLastName(),
        userdto.getGender(),
        userdto.getPassword(),
        (java.sql.Date) new Date(),
      
        "Active");
        return userRepository.save(users);
    }
    public user getSingleUserByid(String id){
        Optional<user> optionuser=userRepository.findById(id);
        return optionuser.get();
        
    }
}
