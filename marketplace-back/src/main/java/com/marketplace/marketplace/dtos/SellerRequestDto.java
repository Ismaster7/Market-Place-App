package com.marketplace.marketplace.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record SellerRequestDto(
        @NotBlank(message = "Campo nome não pode estar vazio")
        @Size(min=4, max = 80)
        String name,
        @Size(min=4, max = 80)
        @NotBlank(message = "Campo sobrenome não pode estar vazio")
        String lastName,
        @Size(min=4, max=160)
        @NotBlank(message = "Campo email não pode estar vazio")
        @Email(message = "Email Inválido!")
        String email,
        @JsonFormat(pattern = "dd/MM/yyyy")
        Date birthday

) {
}
