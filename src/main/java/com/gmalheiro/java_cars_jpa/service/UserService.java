package com.gmalheiro.java_cars_jpa.service;

import com.gmalheiro.java_cars_jpa.controller.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser (UserDto userDto) ;

    UserDto findUserById(Long id);

    void deleteById(Long id);

    UserDto updateUser(UserDto userDto);

    List<UserDto> findAllUser();
}
