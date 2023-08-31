package com.exampledemo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exampledemo.demo.model.user;
import com.exampledemo.demo.service.userService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private userService userservice;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<user>> getUser(){
        return new ResponseEntity<List<user>>(userservice.getUser(),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createUser(){
        return new ResponseEntity<>("Create User",HttpStatus.OK);
    }
}
