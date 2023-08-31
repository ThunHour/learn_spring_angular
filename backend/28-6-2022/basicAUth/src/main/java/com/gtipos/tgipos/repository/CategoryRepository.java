package com.gtipos.tgipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtipos.tgipos.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
    
}
