package com.marketplace.marketplace.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SellerRequestPut(

        @Size(min=4, max = 80)
        String name,
        @Size(min=4, max = 80)

        String lastName,
        @Size(min=4, max=160)

        String email
) {
}
