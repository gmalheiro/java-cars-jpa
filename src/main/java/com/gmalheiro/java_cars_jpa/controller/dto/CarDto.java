package com.gmalheiro.java_cars_jpa.controller.dto;

import com.gmalheiro.java_cars_jpa.entity.Car;
import jakarta.validation.constraints.NotBlank;

public record CarDto(@NotBlank String model,
                     @NotBlank String brand,
                     @NotBlank int year,
                     @NotBlank double price) {
    public Car toEntity(CarDto dto) {
        return new Car.CarBuilder(dto.model, dto.brand, dto.year, dto.price).build();
    }
}