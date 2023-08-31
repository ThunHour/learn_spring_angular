package com.gtipos.tgipos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.gtipos.tgipos.dto.CategoryDto;
import com.gtipos.tgipos.model.Category;
import com.gtipos.tgipos.repository.CategoryRepository;
import com.gtipos.tgipos.service.CategoryService;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryDto, List<CategoryDto>, String, Category> implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    protected JpaRepository<Category, String> getBaseRepository() {
        return categoryRepository;
    }

    @Override
    protected CategoryDto newRespond() {
        return new CategoryDto();
    }
    
    
}
