package com.manojlovski.carmarket.service;

import com.manojlovski.carmarket.dto.request.CustomerRequest;
import com.manojlovski.carmarket.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest customerRequest);

    CustomerResponse updateCustomer(String id, CustomerRequest customerRequest);

    CustomerResponse findById(String id);

    void deleteCustomer(String id);

    List<CustomerResponse> listCustomers();
}
