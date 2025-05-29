package com.manojlovski.carmarket.service;

import com.manojlovski.carmarket.dto.request.CustomerRequest;
import com.manojlovski.carmarket.dto.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest customerRequest);
}
