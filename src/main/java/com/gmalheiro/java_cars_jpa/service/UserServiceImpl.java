package com.gmalheiro.java_cars_jpa.service;

import com.gmalheiro.java_cars_jpa.controller.dto.AddressDto;
import com.gmalheiro.java_cars_jpa.controller.dto.CarDto;
import com.gmalheiro.java_cars_jpa.controller.dto.UserDto;
import com.gmalheiro.java_cars_jpa.entity.User;
import com.gmalheiro.java_cars_jpa.repository.user.UserRepository;
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
        User user = repository.save(userDto.toEntity(userDto));
        AddressDto addressDto = new AddressDto(user.getAddress().getStreet(), user.getAddress().getCity(), user.getAddress().getState(), user.getAddress().getZipCode());
        List<CarDto> carsDto = new ArrayList<>();
        user.getCars().forEach(carEntity -> carsDto.add(new CarDto(carEntity.getModel(),carEntity.getBrand(),carEntity.getCarYear(),carEntity.getPrice())) );
        return new UserDto(user.getName(), user.getRole(), user.getEmail(),addressDto,carsDto);
    }

    @Override
    public UserDto findUserById(Long id) {
        User user = repository.findById(id);
        AddressDto addressDto = new AddressDto(user.getAddress().getStreet(), user.getAddress().getCity(), user.getAddress().getState(), user.getAddress().getZipCode());
        List<CarDto> carsDto = new ArrayList<>();
        user.getCars().forEach(carEntity -> carsDto.add(new CarDto(carEntity.getModel(),carEntity.getBrand(),carEntity.getCarYear(),carEntity.getPrice())) );
        return new UserDto(user.getName(), user.getRole(), user.getEmail(),addressDto, carsDto);
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = repository.merge(userDto.toEntity(userDto));
        AddressDto addressDto = new AddressDto(user.getAddress().getStreet(), user.getAddress().getCity(), user.getAddress().getState(), user.getAddress().getZipCode());
        List<CarDto> carsDto = new ArrayList<>();
        user.getCars().forEach(carEntity -> carsDto.add(new CarDto(carEntity.getModel(),carEntity.getBrand(),carEntity.getCarYear(),carEntity.getPrice())) );
        return new UserDto(user.getName(), user.getRole(), user.getEmail(), addressDto, carsDto);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<UserDto> userDtoList = new ArrayList<>();

        repository.findAll().parallelStream().forEach(user -> {
            AddressDto addressDto = new AddressDto(user.getAddress().getStreet(), user.getAddress().getCity(), user.getAddress().getState(), user.getAddress().getZipCode());
            List<CarDto> carsDto = new ArrayList<>();
            user.getCars().forEach(carEntity -> carsDto.add(new CarDto(carEntity.getModel(),carEntity.getBrand(),carEntity.getCarYear(),carEntity.getPrice())) );
            userDtoList.add(new UserDto(user.getName(), user.getRole(), user.getEmail(), addressDto,carsDto));
        });

        return userDtoList;
    }
}
