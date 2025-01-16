package com.gmalheiro.java_cars_jpa.controller.dto;

import com.gmalheiro.java_cars_jpa.entity.Address;

public record AddressDto(String street,
                         String city,
                         String state,
                         String zipCode) {
    public Address toEntity(AddressDto dto) {
        return new Address(dto.street,dto.city,dto.state,dto.zipCode);
    }
}
