package com.oopservice.oop_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oopservice.oop_service.model.Item;



public interface ItemRepository extends JpaRepository<Item,String>{
    List<Item> findAllByStatus(String status);
}
