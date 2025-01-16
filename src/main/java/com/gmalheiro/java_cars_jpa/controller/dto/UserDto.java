package com.gmalheiro.java_cars_jpa.controller.dto;

import com.gmalheiro.java_cars_jpa.entity.Address;
import com.gmalheiro.java_cars_jpa.entity.Car;
import com.gmalheiro.java_cars_jpa.entity.User;
import com.gmalheiro.java_cars_jpa.enums.Role;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public record UserDto(@NotBlank String name,
                      @NotBlank Role role,
                      @NotBlank String email,
                      @NotBlank AddressDto address,
                      @NotBlank List<CarDto> cars) {
    public User toEntity(UserDto dto) {
        Address addressEntity = address.toEntity(address);
        List<Car> carsEntityList = new ArrayList<>();
        cars.forEach(c -> carsEntityList.add(c.toEntity(c)));
        return new User.UserBuilder(name,email,role)
                .setAddress(addressEntity)
                .setCars(carsEntityList)
                .build();
    }
}
