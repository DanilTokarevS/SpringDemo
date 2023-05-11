package com.example.lab5_spring.dao;


import com.example.lab5_spring.Entity.Users;
import lombok.Data;

@Data
public class RegisterForm {

    private String username;
    private String password;

    public Users toUser() {
        return new Users(username, password, 2);
    }

    public Users toAdmin() {
        return new Users(username, password, 1);
    }

}
