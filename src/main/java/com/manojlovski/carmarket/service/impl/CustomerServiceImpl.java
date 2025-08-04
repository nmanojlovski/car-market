package com.manojlovski.carmarket.service.impl;

import com.manojlovski.carmarket.config.exception.ConflictException;
import com.manojlovski.carmarket.config.exception.NotFoundException;
import com.manojlovski.carmarket.config.security.context.SecurityContext;
import com.manojlovski.carmarket.dto.request.CustomerRequest;
import com.manojlovski.carmarket.dto.response.CustomerResponse;
import com.manojlovski.carmarket.model.Account;
import com.manojlovski.carmarket.model.Customer;
import com.manojlovski.carmarket.model.base.BaseModel;
import com.manojlovski.carmarket.repository.AccountRepository;
import com.manojlovski.carmarket.repository.CustomerRepository;
import com.manojlovski.carmarket.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final SecurityContext securityContext;

    @Override
    @Transactional
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        String accountId = securityContext.getPrincipal().getAccountId();
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new NotFoundException("Account with the id: " + accountId + " not found")
        );
        if (account.getCustomer() != null) {
            throw new ConflictException("Account with the id: " + accountId + " already has a customer associated with it.");
        }


        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setAddress(customerRequest.getAddress());
        customer.setPhone(customerRequest.getPhone());
        customer.setSellerType(customerRequest.getSellerType());
        customerRepository.save(customer);


        account.setCustomer(customer);
        accountRepository.save(account);

        return mapToCustomerResponse(customer);
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->
                new NotFoundException("Customer with the id: " + id + " not found")
        );
        customer.setName(customerRequest.getName());
        customer.setAddress( customerRequest.getAddress());
        customer.setPhone(customerRequest.getPhone());
        customer.setSellerType(customerRequest.getSellerType());
        customerRepository.save(customer);

        return mapToCustomerResponse(customer);
    }

    @Override
    public CustomerResponse findById(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()->
                new NotFoundException("Customer with the id: " + id + " not found")
        );
        return mapToCustomerResponse(customer);

    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerResponse> listCustomers() {
        return customerRepository.findAll().stream().map(this::mapToCustomerResponse).toList();
    }

    private CustomerResponse mapToCustomerResponse(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setPhone(customer.getPhone());
        customerResponse.setSellerType(customer.getSellerType());

        if (customer.getCars() != null) {
            customerResponse.setCarIds(customer.getCars().stream().map(BaseModel::getId).toList());
        }

        customerResponse.setCreatedAt(customer.getCreatedAt());
        customerResponse.setUpdatedAt(customer.getUpdatedAt());

        return customerResponse;
    }
}
