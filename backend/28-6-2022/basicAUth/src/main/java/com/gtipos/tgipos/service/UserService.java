package com.gtipos.tgipos.service;

import java.util.List;

import com.gtipos.tgipos.dto.UserDto;
import com.gtipos.tgipos.model.User;

public interface UserService {
    List<User> getAllUser();

    User getById(String id);

    User createUser(UserDto userDto);

    User updateUser(String id, UserDto userDto);

    User deleteUser(String id);
}
