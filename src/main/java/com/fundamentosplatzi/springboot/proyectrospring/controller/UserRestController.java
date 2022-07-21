package com.fundamentosplatzi.springboot.proyectrospring.controller;

import com.fundamentosplatzi.springboot.proyectrospring.caseuse.GetUser;
import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    //Get
    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }
}