package com.gtipos.tgipos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private String id;
    private String name;

    public CategoryDto() {}

    public CategoryDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    
}
