package com.oopservice.oop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oopservice.oop_service.model.Category;

public interface CategoryRepoitory extends JpaRepository<Category,String>{
    
}
