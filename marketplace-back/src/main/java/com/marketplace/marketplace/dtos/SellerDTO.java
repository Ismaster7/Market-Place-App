package com.marketplace.marketplace.dtos;
import java.util.Date;

public record SellerDTO(

        Long id,
        String name,
        String lastName,
        String email,
        Date birthday
) {
}
