package com.example.demo.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record BeerDto(
        UUID id,
        @Null Integer version,
        @Null OffsetDateTime createdDate,
        @Null OffsetDateTime lastModifiedDate,
        @NotBlank String beerName,
        @NotNull BeerStyleEnum beerStyle,
        @NotNull @Positive Long upc,
        @NotNull BigDecimal price,
        Integer quantityOnHand
) {
}
