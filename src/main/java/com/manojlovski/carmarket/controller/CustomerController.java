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

import java.util.List;

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

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable String id,@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.updateCustomer(id, customerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable String id) {
        return customerService.findById(id);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.listCustomers();
    }
}
