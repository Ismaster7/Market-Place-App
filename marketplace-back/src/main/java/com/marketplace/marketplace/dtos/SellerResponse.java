package com.marketplace.marketplace.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SellerResponse(
        String name,
        String lastName,
        String email
) {
}
