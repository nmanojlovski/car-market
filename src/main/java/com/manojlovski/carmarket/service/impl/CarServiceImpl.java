package com.manojlovski.carmarket.service.impl;

import com.manojlovski.carmarket.config.exception.NotFoundException;
import com.manojlovski.carmarket.config.security.context.SecurityContext;
import com.manojlovski.carmarket.dto.request.CarRequest;
import com.manojlovski.carmarket.dto.response.CarResponse;
import com.manojlovski.carmarket.model.Account;
import com.manojlovski.carmarket.model.Car;
import com.manojlovski.carmarket.model.Customer;
import com.manojlovski.carmarket.model.base.BaseModel;
import com.manojlovski.carmarket.repository.CarRepository;
import com.manojlovski.carmarket.repository.CustomerRepository;
import com.manojlovski.carmarket.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final SecurityContext securityContext;
    private final CustomerRepository customerRepository;

    @Override
    public List<CarResponse> listCars() {
        return carRepository.findAll().stream().map(this::mapToCarResponse).toList();
    }

    @Transactional
    @Override
    public CarResponse createCar(CarRequest carRequest) {
        Car car = new Car();
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setYear(carRequest.getYear());
        car.setPrice(carRequest.getPrice());
        car.setColor(carRequest.getColor());

        String customerId = securityContext.getPrincipal().getCustomerId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new NotFoundException("Customer with the id: " + customerId + " not found")
        );
        car.setCustomer(customer);

        carRepository.save(car);


        return mapToCarResponse(car);
    }

    @Override
    public CarResponse findById(String id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Car with the id: " + id + " not found")
        );
        return mapToCarResponse(car);
    }

    @Transactional
    @Override
    public CarResponse updateCar(String id, CarRequest carRequest) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Car with the id: " + id + " not found")
        );
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setYear(carRequest.getYear());
        car.setPrice(carRequest.getPrice());
        car.setColor(carRequest.getColor());
        carRepository.save(car);

        return mapToCarResponse(car);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        carRepository.deleteById(id);
    }

    private CarResponse mapToCarResponse(Car car) {
        CarResponse carResponse = new CarResponse();
        carResponse.setId(car.getId());
        carResponse.setBrand(car.getBrand());
        carResponse.setModel(car.getModel());
        carResponse.setYear(car.getYear());
        carResponse.setColor(car.getColor());
        carResponse.setPrice(car.getPrice());
        carResponse.setCustomerId(car.getCustomer().getId());



        carResponse.setCreatedAt(car.getCreatedAt());
        carResponse.setUpdatedAt(car.getUpdatedAt());

        return carResponse;
    }
}
