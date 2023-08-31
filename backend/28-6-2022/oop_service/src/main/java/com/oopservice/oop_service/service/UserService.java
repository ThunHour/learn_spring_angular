package com.oopservice.oop_service.service;


import java.util.List;



import com.oopservice.oop_service.dto.UserDto;
import com.oopservice.oop_service.model.User;


public interface UserService {
    public List<User> getAllUser() ;
    public User getById(String id) ;
    public User createUser(UserDto userDto) ;
    public User updateUser(String id, UserDto user) ;
    public User deleteuser(String id) ;
}
