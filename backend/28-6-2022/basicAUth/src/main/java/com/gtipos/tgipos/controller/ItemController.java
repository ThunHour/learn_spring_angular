package com.gtipos.tgipos.controller;

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

import com.gtipos.tgipos.dto.ItemDto;
import com.gtipos.tgipos.model.Item;
import com.gtipos.tgipos.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItem() {
        return new ResponseEntity<>(itemService.getAllItem(), HttpStatus.OK);
    }

    @RequestMapping(value = { "page" }, method = RequestMethod.GET)
    public ResponseEntity<Page<Item>> getItemByPage(int page, int offset) {
        return new ResponseEntity<>(itemService.getAllItemByPage(page, offset), HttpStatus.OK);
    }

    @RequestMapping(value = { "getById" }, method = RequestMethod.GET)
    public ResponseEntity<Item> getSingleItem(@RequestParam String id) {
        if (itemService.getById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(itemService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> createItem(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.createItem(itemDto), HttpStatus.OK);
    }

    @RequestMapping(value = { "update" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> updateItem(String id, @RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.updateItem(id, itemDto), HttpStatus.OK);
    }

    @RequestMapping(value = { "delete" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> deleteItem(String id) {
        return new ResponseEntity<>(itemService.deleteItem(id), HttpStatus.OK);
    }
}
