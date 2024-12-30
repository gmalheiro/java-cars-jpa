package com.gmalheiro.java_cars_jpa.controller.dto;

import com.gmalheiro.java_cars_jpa.entity.Address;
import com.gmalheiro.java_cars_jpa.enums.Role;
import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank String name,
                      @NotBlank String role,
                      @NotBlank String email,
                      @NotBlank Address address) {
}
