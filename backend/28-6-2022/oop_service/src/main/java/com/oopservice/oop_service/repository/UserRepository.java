package com.oopservice.oop_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oopservice.oop_service.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByStatus(String status);
}
