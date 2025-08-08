package com.marketplace.marketplace.service;

import com.marketplace.marketplace.dtos.product.ProductRequest;
import com.marketplace.marketplace.dtos.product.ProductRequestPut;
import com.marketplace.marketplace.dtos.product.ProductResponse;
import com.marketplace.marketplace.exception.ProductNotFound;
import com.marketplace.marketplace.mapper.ProductMapper;
import com.marketplace.marketplace.model.Product;
import com.marketplace.marketplace.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
    }

    public ProductResponse getProductById(Long id){
        Product product = productRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Not found"));
        return productMapper.toDto(product);
    }
    @Transactional
    public ProductResponse saveProduct(ProductRequest productRequest){
        Product product = productMapper.toEntityRequest(productRequest);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return productMapper.toDtoList(products);
    }
    @Transactional
    public ProductResponse updateProduct(ProductRequestPut productRequest){
        // mini dto
        Product product = new Product();
        product.setProductName(productRequest.productName() != null? productRequest.productName() : null);
        product.setPrice(productRequest.price() != null? productRequest.price() : null);
        product.setId(productRequest.id());
        Product oldProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new ProductNotFound("Not found"));
        if(product.getProductName() != null) oldProduct.setProductName(product.getProductName());
        if(product.getPrice() != null)oldProduct.setPrice(product.getPrice());
        productRepository.save(oldProduct);
        return productMapper.toDto(product);
    }

    public Double allSumProductValue(){
        List<Product> products = productRepository.findAll();
        double count = 0;
        for(int i = 0; i < products.size(); i++){
            count += products.get(i).getPrice();
        }
        return count;
//       double price = products.stream()
//               .map(r -> r.getPrice())
//               .reduce(0.0, (acumulador, proximo)-> acumulador + proximo);
    }
}
