package com.manojlovski.carmarket.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CarRequest {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private int year;

    @NotBlank
    private String color;

    @NotNull
    private double price;
}
