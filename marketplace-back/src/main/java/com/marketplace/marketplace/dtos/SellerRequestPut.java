package com.marketplace.marketplace.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record SellerRequestPut(

        @Size(min=4, max = 80)
        String name,
        @Size(min=4, max = 80)

        String lastName,
        @Size(min=4, max=160)

        String email,
        @JsonFormat(pattern = "dd/MM/yyyy")
        Date birthday
) {
}
