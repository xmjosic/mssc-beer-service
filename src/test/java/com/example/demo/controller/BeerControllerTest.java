package com.example.demo.controller;

import com.example.demo.dto.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static com.example.demo.dto.BeerStyleEnum.PALE_ALE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  void getBeer() throws Exception {
    mockMvc
        .perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void createBeer() throws Exception {
    BeerDto beerDto =
        BeerDto.builder()
            .upc(123L)
            .price(new BigDecimal(123))
            .beerName("Test Beer")
            .beerStyle(PALE_ALE)
            .build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc
        .perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeer() throws Exception {
    BeerDto beerDto =
        BeerDto.builder()
            .upc(123L)
            .price(new BigDecimal(123))
            .beerName("Test Beer")
            .beerStyle(PALE_ALE)
            .build();
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);

    mockMvc
        .perform(
            put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
        .andExpect(status().isNoContent());
  }
}
