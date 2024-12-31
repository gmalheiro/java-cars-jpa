package com.gmalheiro.java_cars_jpa.service;

import com.gmalheiro.java_cars_jpa.controller.dto.UserDto;
import com.gmalheiro.java_cars_jpa.entity.User;
import com.gmalheiro.java_cars_jpa.repository.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private final ModelMapper mapper;

    public UserServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    private UserDto toDto (User user) {return mapper.map(user,UserDto.class);}

    private User toEntity (UserDto user) {return mapper.map(user,User.class);}

    @Override
    public UserDto createUser(UserDto userDto) {
        return toDto(repository.save(toEntity(userDto)));
    }

    @Override
    public UserDto findUserById(Long id) {
        return toDto(repository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return  toDto(repository.merge(toEntity(userDto)));
    }

    @Override
    public List<UserDto> findAllUser() {
        List<UserDto> userDtoList  = new ArrayList<>();

        repository.findAll().parallelStream().forEach(user -> {
            userDtoList.add(toDto(user));
        });

        return userDtoList;
    }
}
