package com.oopservice.oop_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private String gender;
    private String password;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.password = password;
    }
}
