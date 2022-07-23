package com.example.demo.dao;

import com.example.demo.dto.BeerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static com.example.demo.dto.BeerStyleEnum.IPA;

@SpringBootTest
class BeerRepositoryTest {

  @Autowired private BeerRepository repository;

  @Test
  void getBeerById() {
    BeerDto beerById = repository.getBeerById(UUID.randomUUID());
    Assertions.assertNotNull(beerById);
  }

  @Test
  void saveBeer() {
    BeerDto request = BeerDto.builder().beerName("Pipi beer").beerStyle(IPA).build();
    URI uri = repository.saveBeer(request);

    Assertions.assertNotNull(uri);
    System.out.println(uri);
  }

  @Test
  void updateBeer() {
    BeerDto request = BeerDto.builder().beerName("Pipi beer").beerStyle(IPA).build();
    repository.updateBeer(UUID.randomUUID(), request);
  }

  @Test
  void deleteBeer() {
    repository.deleteBeer(UUID.randomUUID());
  }
}
