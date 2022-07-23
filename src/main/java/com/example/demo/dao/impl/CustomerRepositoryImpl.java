package com.example.demo.dao.impl;

import com.example.demo.configuration.RestTemplateConfigProps;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

  private final RestTemplate restTemplate;
  private final RestTemplateConfigProps props;

  @Override
  public CustomerDto getCustomerById(UUID uuid) {
    return restTemplate.getForObject(props.getCustomerByIdPath(), CustomerDto.class, uuid);
  }

  @Override
  public URI saveCustomer(CustomerDto customerDto) {
    return restTemplate.postForLocation(props.saveCustomerPath(), customerDto);
  }

  @Override
  public void updateCustomer(UUID uuid, CustomerDto customerDto) {
    restTemplate.put(props.updateCustomerPath(), customerDto, uuid);
  }

  @Override
  public void deleteCustomer(UUID uuid) {
    restTemplate.delete(props.deleteCustomerPath(), uuid);
  }
}
