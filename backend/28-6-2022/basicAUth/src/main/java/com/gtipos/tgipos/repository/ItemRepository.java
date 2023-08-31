package com.gtipos.tgipos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtipos.tgipos.model.Item;

public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findAllByStatus(String status);
}
