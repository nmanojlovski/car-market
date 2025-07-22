package com.manojlovski.carmarket.service;

import com.manojlovski.carmarket.dto.request.CarRequest;
import com.manojlovski.carmarket.dto.response.CarResponse;

import java.util.List;

public interface CarService {

    List<CarResponse> listCars();

    CarResponse createCar(CarRequest carRequest);

    CarResponse findById(String id);

    CarResponse updateCar(String id, CarRequest carRequest);

    void deleteById(String id);

}
