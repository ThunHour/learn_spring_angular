package com.oopservice.oop_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.oopservice.oop_service.dto.CategoryDto;
import com.oopservice.oop_service.model.Category;
import com.oopservice.oop_service.repository.CategoryRepoitory;
import com.oopservice.oop_service.service.CategoryService;


@Service

public class CategoryServiceImpl extends BaseServiceImpl<CategoryDto, List<CategoryDto>, String, Category>
        implements CategoryService {
    @Autowired
    private CategoryRepoitory categoryRepoitory;

    @Override
    protected JpaRepository<Category, String> getBaseRepository() {
        return categoryRepoitory;
    }
    @Override
    protected CategoryDto newResponse() {
       
        return new CategoryDto();
    }

}
