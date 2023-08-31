package com.exampledemo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exampledemo.demo.model.user;

@Service

public class userService {
    public List<user> getUser(){
        List<user> userList=new ArrayList<>();
        userList.add(new user("001","seakkimhour","M"));
        userList.add(new user("002","china","M"));
        userList.add(new user("003","rith","M"));
        return userList;
    }
}
