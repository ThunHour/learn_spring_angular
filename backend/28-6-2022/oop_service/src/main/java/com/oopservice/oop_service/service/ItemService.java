package com.oopservice.oop_service.service;
import java.util.List;
import org.springframework.data.domain.Page;
import com.oopservice.oop_service.dto.ItemDto;
import com.oopservice.oop_service.model.Item;

public interface ItemService {
    

    List<Item> getAllItem();
    

     Item getItemById(String id) ;

     Item createItem(ItemDto itemDto) ;

     Item updateItem(String id, ItemDto itemDto) ;

     Item deleteItem(String id) ;
     Page<Item> getAllItemByPage(int page,int offset);
}
