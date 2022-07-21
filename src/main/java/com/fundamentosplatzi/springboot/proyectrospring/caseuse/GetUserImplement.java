package com.fundamentosplatzi.springboot.proyectrospring.caseuse;

import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import com.fundamentosplatzi.springboot.proyectrospring.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
