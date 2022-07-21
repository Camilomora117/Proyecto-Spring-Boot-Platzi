package com.fundamentosplatzi.springboot.proyectrospring.caseuse;

import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import com.fundamentosplatzi.springboot.proyectrospring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUse, Long id) {
        return userService.update(newUse, id);
    }
}
