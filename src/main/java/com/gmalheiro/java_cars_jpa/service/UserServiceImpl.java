package com.gmalheiro.java_cars_jpa.service;

import com.gmalheiro.java_cars_jpa.controller.dto.AddressDto;
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

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = repository.save(userDto.toEntity(userDto.name(),userDto.role(),userDto.email(),userDto.address()));
         AddressDto addressDto = new AddressDto(user.getAddress().getStreet(),user.getAddress().getCity(),user.getAddress().getState(),user.getAddress().getZipCode());
         return  new UserDto(user.getName(),user.getRole(),user.getEmail(),addressDto);
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = repository.findById(id);
        AddressDto addressDto = new AddressDto(user.getAddress().getStreet(),user.getAddress().getCity(),user.getAddress().getState(),user.getAddress().getZipCode());
        return new UserDto(user.getName(), user.getRole(),user.getEmail(),addressDto);
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = repository.merge(new User(userDto.name(),userDto.role(),userDto.email()));
        AddressDto addressDto = new AddressDto(user.getAddress().getStreet(),user.getAddress().getCity(),user.getAddress().getState(),user.getAddress().getZipCode());
        return  new UserDto(user.getName(),user.getRole(),user.getEmail(),addressDto);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<UserDto> userDtoList  = new ArrayList<>();

        repository.findAll().parallelStream().forEach(user -> {
            AddressDto addressDto = new AddressDto(user.getAddress().getStreet(),user.getAddress().getCity(),user.getAddress().getState(),user.getAddress().getZipCode());
            userDtoList.add(new UserDto(user.getName(),user.getRole(),user.getEmail(),addressDto));
        });

        return userDtoList;
    }
}
