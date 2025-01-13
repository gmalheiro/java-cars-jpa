package com.gmalheiro.java_cars_jpa.controller.dto;

import com.gmalheiro.java_cars_jpa.entity.Address;

public record AddressDto(String street,
                         String city,
                         String state,
                         String zipCode) {
    Address toEntity() {
        return new Address(street,city,state,zipCode);
    }
}
