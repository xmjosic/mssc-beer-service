package com.example.demo.dao.impl;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
class CustomerRepositoryImplTest {

  @Autowired private CustomerRepository repository;

  @Test
  void getCustomerById() {
    CustomerDto customerById = repository.getCustomerById(UUID.randomUUID());
    Assertions.assertNotNull(customerById);
  }

  @Test
  void saveCustomer() {
    CustomerDto request = CustomerDto.builder().name("test").build();
    URI uri = repository.saveCustomer(request);
    Assertions.assertNotNull(uri);
    System.out.println(uri);
  }

  @Test
  void updateCustomer() {
    CustomerDto request = CustomerDto.builder().name("test").build();
    repository.updateCustomer(UUID.randomUUID(), request);
  }

  @Test
  void deleteCustomer() {
    repository.deleteCustomer(UUID.randomUUID());
  }
}
