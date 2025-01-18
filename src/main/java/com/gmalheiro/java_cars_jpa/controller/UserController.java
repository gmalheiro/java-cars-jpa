package com.gmalheiro.java_cars_jpa.controller;

import com.gmalheiro.java_cars_jpa.controller.dto.UserDto;
import com.gmalheiro.java_cars_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> listUsers () {
        return ResponseEntity.ok(service.findAllUser());
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser (@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.updateUser(userDto));
    }
}
