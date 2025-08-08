package com.marketplace.marketplace.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @Size(message = " The Name length must be between 2 and 40 letters", min = 2, max = 40)
        @NotBlank(message = "Name cannot be null")
        String productName,
        @NotNull(message = "Price cannot be null")
        Double price
) {
}
