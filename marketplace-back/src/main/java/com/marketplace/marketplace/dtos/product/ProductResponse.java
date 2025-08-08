package com.marketplace.marketplace.dtos.product;

public record ProductResponse(
        Long id,
        String productName,
        Double price
) {
}
