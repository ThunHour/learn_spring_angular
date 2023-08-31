package com.oopservice.oop_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oopservice.oop_service.dto.UserDto;
import com.oopservice.oop_service.model.User;
import com.oopservice.oop_service.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @RequestMapping(value = { "getById" }, method = RequestMethod.GET)
    public ResponseEntity<User> getSingleUser(@RequestParam String id) {
        if (userService.getById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }
    
    @RequestMapping(value = {"update"},method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUSer(String id,@RequestBody UserDto user){
        return new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.OK);
    }

    @RequestMapping(value = {"delete"},method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@RequestParam String id){
        return new ResponseEntity<>(userService.deleteuser(id),HttpStatus.OK);
    }
}
