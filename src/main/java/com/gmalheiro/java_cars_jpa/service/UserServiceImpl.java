package com.gmalheiro.java_cars_jpa.service;

import com.gmalheiro.java_cars_jpa.controller.dto.UserDto;
import com.gmalheiro.java_cars_jpa.repository.user.UserRepository;
import com.gmalheiro.java_cars_jpa.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private final UserMapper mapper = UserMapper.INSTANCE;


    @Override
    public UserDto createUser(UserDto userDto) {
        return mapper.toDto(repository.save(mapper.toEntity(userDto)));
    }

    @Override
    public UserDto findUserById(Long id) {
        return mapper.toDto(repository.findById(id));
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return  mapper.toDto(repository.merge(mapper.toEntity(userDto)));
    }

    @Override
    public List<UserDto> findAllUser() {
        List<UserDto> userDtoList  = new ArrayList<>();

        repository.findAll().parallelStream().forEach(user -> {
            userDtoList.add(mapper.toDto(user));
        });

        return userDtoList;
    }
}
