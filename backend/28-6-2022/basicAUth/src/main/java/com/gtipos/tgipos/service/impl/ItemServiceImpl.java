package com.gtipos.tgipos.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gtipos.tgipos.dto.ItemDto;
import com.gtipos.tgipos.model.Item;
import com.gtipos.tgipos.repository.ItemRepository;
import com.gtipos.tgipos.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAllByStatus("Active");
    };

    public Page<Item> getAllItemByPage(int page, int offset) {
        return itemRepository.findAll(PageRequest.of(page, offset));
    }

    public Item getById(String id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.get();
    }

    public Item createItem(ItemDto itemDto) {
        return itemRepository.save(new Item(UUID.randomUUID().toString(), itemDto.getName(), itemDto.getPic(),
                itemDto.getPrice(), new Date(), "Active"));
    }

    public Item updateItem(String id, ItemDto itemDto) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        Item itemFromRepo = optionalItem.get();
        itemFromRepo.setName(itemDto.getName());
        itemFromRepo.setPic(itemDto.getPic());
        itemFromRepo.setPrice(itemDto.getPrice());
        return itemRepository.save(itemFromRepo);
    }

    public Item deleteItem(String id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        Item itemFromRepo = optionalItem.get();
        itemFromRepo.setStatus("Delete");
        return itemRepository.save(itemFromRepo);
    }
}
