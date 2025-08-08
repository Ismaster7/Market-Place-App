package com.marketplace.marketplace.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequestPut(
        @NotNull
        Long id,
        @Size(min = 2, max = 40)
        String productName,
        Double price
) {
}
