package com.gtipos.tgipos.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gtipos.tgipos.dto.ItemDto;
import com.gtipos.tgipos.model.Item;

public interface ItemService {
    List<Item> getAllItem();

    Page<Item> getAllItemByPage(int page, int offset);

    Item getById(String id);

    Item createItem(ItemDto itemDto);

    Item updateItem(String id, ItemDto itemDto);

    Item deleteItem(String id);
}
