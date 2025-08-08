package com.marketplace.marketplace.mapper;

import com.marketplace.marketplace.dtos.product.ProductRequest;
import com.marketplace.marketplace.dtos.product.ProductResponse;
import com.marketplace.marketplace.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ProductMapper  {

    public Product toEntity(ProductResponse productResponse);
    public ProductResponse toDto( Product product);
    public List<ProductResponse> toDtoList (List<Product> productList);
    public Product toEntityRequest (ProductRequest productRequest);
}
