package com.oopservice.oop_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oopservice.oop_service.dto.ItemDto;
import com.oopservice.oop_service.model.Item;
import com.oopservice.oop_service.service.ItemService;


@RestController
@RequestMapping("/item")
public class itemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping(value = {"page"},method = RequestMethod.GET)
    public ResponseEntity<Page<Item>> getitemByPage(int page,int offset) {
        return new ResponseEntity<Page<Item>>(itemService.getAllItemByPage(page,offset), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getitem() {
        return new ResponseEntity<>(itemService.getAllItem(), HttpStatus.OK);
    }

    @RequestMapping(value = { "getById" }, method = RequestMethod.GET)
    public ResponseEntity<Item> getSingleitem(@RequestParam String id) {
        if (itemService.getItemById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> createitem(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.createItem(itemDto), HttpStatus.OK);
    }
    
    @RequestMapping(value = {"update"},method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> updateitem(String id,@RequestBody ItemDto item){
        return new ResponseEntity<>(itemService.updateItem(id,item),HttpStatus.OK);
    }

    @RequestMapping(value = {"delete"},method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> deleteitem(@RequestParam String id){
        return new ResponseEntity<>(itemService.deleteItem(id),HttpStatus.OK);
    }
}
