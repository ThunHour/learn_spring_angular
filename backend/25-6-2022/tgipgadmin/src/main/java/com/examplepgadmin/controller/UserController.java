package com.examplepgadmin.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("get user", HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createUser(){
        return new ResponseEntity<>("Create User",HttpStatus.OK);
    }

}