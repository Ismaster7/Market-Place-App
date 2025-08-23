package com.marketplace.marketplace.mapper;

import com.marketplace.marketplace.dtos.SellerDTO;
import com.marketplace.marketplace.dtos.SellerRequestDto;
import com.marketplace.marketplace.dtos.SellerRequestPut;
import com.marketplace.marketplace.dtos.SellerResponse;
import com.marketplace.marketplace.model.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SellerMapper {
    Seller toEntityPost(SellerRequestDto sellerRequestDto);
    @Mapping(target = "id", ignore = true)
    Seller toEntityPut(SellerRequestPut sellerRequestPut);
    List<SellerResponse> toDtoList(List<Seller> sellers);
    Seller toEntitySeller(SellerDTO sellerDTO);
    SellerDTO toDtoSeller(Seller seller);
}
