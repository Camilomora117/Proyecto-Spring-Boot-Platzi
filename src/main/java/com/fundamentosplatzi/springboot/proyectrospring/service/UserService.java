package com.fundamentosplatzi.springboot.proyectrospring.service;

import com.fundamentosplatzi.springboot.proyectrospring.entity.User;
import com.fundamentosplatzi.springboot.proyectrospring.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private Log LOG = LogFactory.getLog(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

     @Transactional
    public void SaveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("Usuarios Insertados : " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
