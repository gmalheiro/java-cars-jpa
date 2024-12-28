package com.gmalheiro.java_cars_jpa.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record CarDto(@NotBlank String model,
                     @NotBlank String brand,
                     @NotBlank int year) {
}