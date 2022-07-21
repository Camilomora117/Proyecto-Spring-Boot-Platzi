package com.fundamentosplatzi.springboot.proyectrospring.controller;

import com.fundamentosplatzi.springboot.proyectrospring.caseuse.CreateUser;
import com.fundamentosplatzi.springboot.proyectrospring.caseuse.DeleteUser;
import com.fundamentosplatzi.springboot.proyectrospring.caseuse.GetUser;
import com.fundamentosplatzi.springboot.proyectrospring.caseuse.UpdateUser;
import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import com.fundamentosplatzi.springboot.proyectrospring.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;

    private CreateUser createUser;

    private DeleteUser deleteUser;

    private UpdateUser updateUser;

    private UserRepository userRepository;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
    }

    //Get
    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }

    //Post
    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    //Delete
    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        deleteUser.remove(id);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }

    //Put
    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUse, @PathVariable Long id ){
        return new ResponseEntity<> (updateUser.update(newUse, id), HttpStatus.OK);
    }

    //Pagination
    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }

}
