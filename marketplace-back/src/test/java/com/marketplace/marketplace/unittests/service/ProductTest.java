package com.marketplace.marketplace.unittests.service;

import com.marketplace.marketplace.dtos.product.ProductResponse;
import com.marketplace.marketplace.mapper.ProductMapper;
import com.marketplace.marketplace.unittests.service.mocks.ProductMock;
import com.marketplace.marketplace.model.Product;
import com.marketplace.marketplace.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductTest {
    ProductMock input;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp(){
 input = new ProductMock();
    }

    @Test
    void shouldFindProductById(){
        //Arrange
        Product product = input.mockEntity();
        ProductResponse productResponse = input.mockResponse();

        // Act
        when(productRepository.findById(product.getId()))
                .thenReturn(Optional.of(product));
        when(productMapper.toDto(product)).thenReturn(productResponse);

        var result = productService.getProductById(0L);

        assertNotNull(result);
        assertEquals("Booster Quadruplo", result.productName());

    }

}
