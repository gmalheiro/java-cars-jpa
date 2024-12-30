package com.gmalheiro.java_cars_jpa.utils.mapper;

import com.gmalheiro.java_cars_jpa.controller.dto.CarDto;
import com.gmalheiro.java_cars_jpa.entity.Car;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDto(Car car);

    Car toEntity(CarDto carDto);
}
