package com.gmalheiro.java_cars_jpa.controller;

import com.gmalheiro.java_cars_jpa.controller.dto.UserDto;
import com.gmalheiro.java_cars_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDto createUser (@RequestBody UserDto userDto) {
        return service.createUser(userDto);
    }
}
