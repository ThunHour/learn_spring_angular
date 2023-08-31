package com.examplepgadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examplepgadmin.model.user;

public interface UserRepository extends JpaRepository<user,String>{
    
}
