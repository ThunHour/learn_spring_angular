package com.gtipos.tgipos.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtipos.tgipos.dto.UserDto;
import com.gtipos.tgipos.model.User;
import com.gtipos.tgipos.repository.UserRepository;
import com.gtipos.tgipos.service.UserService;


@Service
public class UserServiceImpl implements UserService {
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

    public User updateUser(String id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        User userFromRepo = optionalUser.get();
        userFromRepo.setFirstName(userDto.getFirstName());
        userFromRepo.setLastName(userDto.getLastName());
        userFromRepo.setGender(userDto.getGender());
        userFromRepo.setPassword(userDto.getPassword());
        return userRepository.save(userFromRepo);
    }

    public User deleteUser(String id) { 
        Optional<User> optionalUser = userRepository.findById(id);
        User userFromRepo = optionalUser.get();
        userFromRepo.setStatus("Delete");
        return userRepository.save(userFromRepo);
    }
}
