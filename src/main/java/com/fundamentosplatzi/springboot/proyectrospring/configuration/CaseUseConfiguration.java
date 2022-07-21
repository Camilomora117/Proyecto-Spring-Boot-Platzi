package com.fundamentosplatzi.springboot.proyectrospring.configuration;

import com.fundamentosplatzi.springboot.proyectrospring.caseuse.GetUser;
import com.fundamentosplatzi.springboot.proyectrospring.caseuse.GetUserImplement;
import com.fundamentosplatzi.springboot.proyectrospring.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }

}
