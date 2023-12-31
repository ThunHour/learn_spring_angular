package com.gtipos.tgipos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private String id;
    private String name;
    private String pic;
    private float price;

    public ItemDto() {
    }

    public ItemDto(String id, String name, String pic, float price) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.price = price;
    }

}
