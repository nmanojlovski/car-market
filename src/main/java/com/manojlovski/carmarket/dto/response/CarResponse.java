package com.manojlovski.carmarket.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class CarResponse {

    private String id;

    private String brand;

    private String model;

    private int year;

    private String color;

    private double price;

    private String customerId;

    private Instant createdAt;

    private Instant updatedAt;

}
