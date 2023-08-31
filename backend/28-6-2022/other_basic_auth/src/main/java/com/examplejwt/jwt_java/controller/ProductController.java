package com.examplejwt.jwt_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <String>  getAllProduct(){
        return new ResponseEntity<>("get all user",HttpStatus.OK);
    }
}
