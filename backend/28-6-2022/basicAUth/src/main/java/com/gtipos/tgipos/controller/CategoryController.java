package com.gtipos.tgipos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gtipos.tgipos.model.Category;
import com.gtipos.tgipos.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = { "getById" }, method = RequestMethod.GET)
    public ResponseEntity<Category> getSingleItem(@RequestParam String id) {
        
        if (categoryService.getById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }
}
