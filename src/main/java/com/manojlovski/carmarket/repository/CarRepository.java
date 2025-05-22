package com.manojlovski.carmarket.repository;

import com.manojlovski.carmarket.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
