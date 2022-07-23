package com.example.demo.dao;

import com.example.demo.dto.BeerDto;

import java.net.URI;
import java.util.UUID;

public interface BeerRepository {
  BeerDto getBeerById(UUID uuid);

  URI saveBeer(BeerDto beerDto);

  void updateBeer(UUID uuid, BeerDto beerDto);

  void deleteBeer(UUID uuid);
}
