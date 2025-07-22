package com.marketplace.marketplace.dtos;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marketplace.marketplace.serializer.GenderSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@JsonPropertyOrder({"id", "email", "lastname", "name"})
public record SellerResponse(
        @JsonProperty("nome")
        String name,
        @JsonProperty("sobrenome")
        String lastName,
        @JsonIgnore
        String email,
        @JsonFormat(pattern = "dd/MM/yyyy")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        Date birthday,
        @JsonSerialize(using = GenderSerializer.class)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String gender
) {
}
