package com.oopservice.oop_service.dto;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ItemDto {
  
    public ItemDto(String name, String pic, float price) {
        this.name = name;
        this.pic = pic;
        this.price = price;
    }
    public ItemDto() {
    }

    private String name;
  
    private String pic;

    private float price;
 

}
