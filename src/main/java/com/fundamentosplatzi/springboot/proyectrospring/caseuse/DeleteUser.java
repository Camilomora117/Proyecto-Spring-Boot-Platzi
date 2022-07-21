package com.fundamentosplatzi.springboot.proyectrospring.caseuse;

import com.fundamentosplatzi.springboot.proyectrospring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(Long id) {
        userService.delete(id);
    }
}
