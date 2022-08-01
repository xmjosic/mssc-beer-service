package com.example.demo.bootstrap;

import com.example.demo.entity.Beer;
import com.example.demo.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
public class BeerLoader implements ApplicationRunner {

  private final BeerRepository beerRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (beerRepository.count() == 0) {
      beerRepository.save(
          Beer.builder()
              .beerName("Mango Bobs")
              .beerStyle("IPA")
              .quantityToBrew(200)
              .upc(965710412949L)
              .price(new BigDecimal("15.99"))
              .minOnHand(12)
              .build());

      beerRepository.save(
          Beer.builder()
              .beerName("Galaxy cat")
              .beerStyle("PALE_ALE")
              .quantityToBrew(200)
              .upc(965710412950L)
              .price(new BigDecimal("14.99"))
              .minOnHand(12)
              .build());
    }

    log.debug("Loaded beers: {}", beerRepository.count());
  }
}
