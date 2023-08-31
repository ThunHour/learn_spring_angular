package com.gtipos.tgipos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtipos.tgipos.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByStatus(String status);
}
