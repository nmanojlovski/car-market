package com.manojlovski.carmarket.controller;

import com.manojlovski.carmarket.dto.request.AccountRequest;
import com.manojlovski.carmarket.dto.request.CustomerRequest;
import com.manojlovski.carmarket.dto.response.AccountResponse;
import com.manojlovski.carmarket.dto.response.CustomerResponse;
import com.manojlovski.carmarket.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }
}
