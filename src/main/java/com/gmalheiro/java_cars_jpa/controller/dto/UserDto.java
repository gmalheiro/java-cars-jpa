package com.gmalheiro.java_cars_jpa.controller.dto;

import com.gmalheiro.java_cars_jpa.entity.Address;
import com.gmalheiro.java_cars_jpa.entity.User;
import com.gmalheiro.java_cars_jpa.enums.Role;
import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank String name,
                      @NotBlank Role role,
                      @NotBlank String email,
                      @NotBlank AddressDto address) {
    public User toEntity(String name,Role role, String email,AddressDto address) {
        return new User(name,role,email,address.toEntity());
    }
}
