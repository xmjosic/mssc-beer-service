package com.example.demo.controller;

import com.example.demo.dto.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

  @GetMapping("/{beerId}")
  public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
    // TODO impl
    return ResponseEntity.ok(BeerDto.builder().build());
  }

  @PostMapping
  public ResponseEntity<Void> createBeer(@RequestBody BeerDto beerDto) {
    // TODO impl
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
    // TODO impl
  }
}
