package com.fundamentosplatzi.springboot.proyectrospring.caseuse;

import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import com.fundamentosplatzi.springboot.proyectrospring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
