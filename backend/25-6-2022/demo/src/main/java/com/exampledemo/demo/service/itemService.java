package com.exampledemo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exampledemo.demo.model.Item;
@Service
public class itemService {
    public List<Item> getItem(){
        List<Item> listItem=new ArrayList<>();
        listItem.add(new Item("001","pizza","pizza.jpg",10.0f));
        listItem.add(new Item("002","sanwhich","sanwhich.jpg",3.0f));
        return listItem;
    }
}
