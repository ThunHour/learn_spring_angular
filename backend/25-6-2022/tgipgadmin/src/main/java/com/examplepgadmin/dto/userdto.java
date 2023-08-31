package com.examplepgadmin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userdto {
    private String firstName;
    private String lastName;
    private String gender;
    private String password;
    public userdto() {}

    public userdto(String firstName, String lastName, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.password = password;
    }

    
    
}