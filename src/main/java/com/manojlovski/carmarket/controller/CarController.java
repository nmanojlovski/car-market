package com.manojlovski.carmarket.controller;

import com.manojlovski.carmarket.dto.request.CarRequest;
import com.manojlovski.carmarket.dto.response.CarResponse;
import com.manojlovski.carmarket.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarResponse> listCars() {
        return carService.listCars();
    }

    @GetMapping("/{id}")
    public CarResponse getCar(@PathVariable String id) {
        return carService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse createCar(@RequestBody @Valid CarRequest carRequest) {
        return carService.createCar(carRequest);
    }

    @PutMapping("/{id}")
    public CarResponse updateCar(@PathVariable String id, @RequestBody @Valid CarRequest carRequest) {
        return carService.updateCar(id, carRequest);
    }
}
