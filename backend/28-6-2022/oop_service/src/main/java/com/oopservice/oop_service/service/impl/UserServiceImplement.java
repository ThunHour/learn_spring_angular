package com.oopservice.oop_service.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oopservice.oop_service.dto.UserDto;
import com.oopservice.oop_service.model.User;
import com.oopservice.oop_service.repository.UserRepository;
import com.oopservice.oop_service.service.UserService;

@Service
public class UserServiceImplement implements UserService{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAllByStatus("Active");
    };

    public User getById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }

    }

    public User createUser(UserDto userDto) {
        User user = new User(UUID.randomUUID().toString(), userDto.getFirstName(), userDto.getLastName(),
                userDto.getGender(),
                userDto.getPassword(), new Date(), "Active");
        return userRepository.save(user);
    }

    public User updateUser(String id, UserDto user) {
        Optional<User> optionalUser = userRepository.findById(id);
        User userFromRepo = optionalUser.get();
        userFromRepo.setFirstName(user.getFirstName());
        userFromRepo.setLastName(user.getLastName());
        userFromRepo.setPassword(user.getPassword());
        userFromRepo.setGender(user.getGender());
        return userRepository.save(userFromRepo);
    }

    public User deleteuser(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User userFromRepo = optionalUser.get();
        userFromRepo.setStatus("Delete");
        return userRepository.save(userFromRepo);
    }
}
