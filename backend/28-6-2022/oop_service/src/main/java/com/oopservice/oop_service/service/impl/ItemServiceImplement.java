package com.oopservice.oop_service.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.oopservice.oop_service.dto.ItemDto;
import com.oopservice.oop_service.model.Item;
import com.oopservice.oop_service.repository.ItemRepository;
import com.oopservice.oop_service.service.ItemService;
@Service
public class ItemServiceImplement implements ItemService {
        
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAllByStatus("Active");
    };

    public Item getItemById(String id) {
        Optional<Item> optionalUser = itemRepository.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }

    }

    public Item createItem(ItemDto itemDto) {
        Item newitem = new Item();
        newitem.setId(UUID.randomUUID().toString());
        newitem.setName(itemDto.getName());
        newitem.setPic(itemDto.getPic());
        newitem.setPrice(itemDto.getPrice());
        newitem.setStatus("Active");
        newitem.setCreatedate(new Date());
        return itemRepository.save(newitem);
    }

    public Item updateItem(String id, ItemDto itemDto) {
        Optional<Item> optionalUser = itemRepository.findById(id);
        Item userFromRepo = optionalUser.get();
        userFromRepo.setName(itemDto.getName());
        userFromRepo.setPic(itemDto.getPic());
        userFromRepo.setPrice(itemDto.getPrice());
        return itemRepository.save(userFromRepo);
    }

    public Item deleteItem(String id) {
        Optional<Item> optionalUser = itemRepository.findById(id);
        Item userFromRepo = optionalUser.get();
        userFromRepo.setStatus("Delete");
        return itemRepository.save(userFromRepo);
    }
    public Page<Item> getAllItemByPage(int page,int offset){
        return  itemRepository.findAll(PageRequest.of(page,offset));

    }
}
