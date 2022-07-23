package com.example.demo.dao.impl;

import com.example.demo.configuration.RestTemplateConfigProps;
import com.example.demo.dao.BeerRepository;
import com.example.demo.dto.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BeerRepositoryImpl implements BeerRepository {

  private final RestTemplate restTemplate;
  private final RestTemplateConfigProps props;

  @Override
  public BeerDto getBeerById(UUID uuid) {
    return restTemplate.getForObject(props.getBeerByIdPath(), BeerDto.class, uuid);
  }

  @Override
  public URI saveBeer(BeerDto beerDto) {
    return restTemplate.postForLocation(props.saveBeerPath(), beerDto);
  }

  @Override
  public void updateBeer(UUID uuid, BeerDto beerDto) {
    restTemplate.put(props.updateBeerPath(), beerDto, uuid);
  }

  @Override
  public void deleteBeer(UUID uuid) {
    restTemplate.delete(props.deleteBeerPath(), uuid);
  }
}
