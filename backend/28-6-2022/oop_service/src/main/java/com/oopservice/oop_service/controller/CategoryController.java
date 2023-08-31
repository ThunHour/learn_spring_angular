package com.oopservice.oop_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oopservice.oop_service.model.Category;
import com.oopservice.oop_service.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private  CategoryServiceImpl categoryServiceImpl;
    @RequestMapping(value = {"getById"},method = RequestMethod.GET)
    public ResponseEntity<Category> getSingalCategory(@RequestParam String id){
        if(categoryServiceImpl.getById(id)==null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryServiceImpl.getById(id),HttpStatus.OK);
        
    }

}
