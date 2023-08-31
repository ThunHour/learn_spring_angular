package com.exampledemo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exampledemo.demo.model.Item;
import com.exampledemo.demo.service.itemService;


@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private itemService itemservice;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItem(){
        return new ResponseEntity<List<Item>>(itemservice.getItem(),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createItem(){
        return new ResponseEntity<>("Create Item",HttpStatus.OK);
    }
}
