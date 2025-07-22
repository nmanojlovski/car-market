package com.manojlovski.carmarket.service;

import com.manojlovski.carmarket.dto.request.CustomerRequest;
import com.manojlovski.carmarket.dto.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest customerRequest);
    //CustomerResponse updateCustomer(String id, CustomerRequest customerRequest);
    //CustomerResponse findById(String id);
    //CustomerResponse deleteCustomer(String id);
    //CustomerResponse listCustomers();
}
