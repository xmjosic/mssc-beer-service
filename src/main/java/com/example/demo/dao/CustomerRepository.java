package com.example.demo.dao;

import com.example.demo.dto.CustomerDto;

import java.net.URI;
import java.util.UUID;

public interface CustomerRepository {
  CustomerDto getCustomerById(UUID customerId);

  URI saveCustomer(CustomerDto customerDto);

  void updateCustomer(UUID customerId, CustomerDto customerDto);

  void deleteCustomer(UUID customerId);
}
