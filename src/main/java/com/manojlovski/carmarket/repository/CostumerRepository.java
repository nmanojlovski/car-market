package com.manojlovski.carmarket.repository;

import com.manojlovski.carmarket.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Customer, String> {
}
