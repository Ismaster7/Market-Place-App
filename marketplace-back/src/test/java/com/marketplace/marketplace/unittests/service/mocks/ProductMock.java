package com.marketplace.marketplace.unittests.service.mocks;

import com.marketplace.marketplace.dtos.product.ProductResponse;
import com.marketplace.marketplace.model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProductMock {
    public Product mockEntity(){
        return mockEntity(0L);
    }

    public Product mockEntity(Long id){
        return new Product(id, "Booster Quadruplo", 40.00);
    }

    public List<Product> mockEntityList(Integer elements ){
        List<Product> products = new ArrayList<>();
        for(Long i = 0L; i < elements; i++){
            products.add(mockEntity(i));
        }
        return products;

    }

    public ProductResponse mockResponse() {
        return mockResponse(0L);

    }

    public ProductResponse mockResponse(Long i){
        return new ProductResponse(i, "Booster Quadruplo", 40.00);
    }
}
