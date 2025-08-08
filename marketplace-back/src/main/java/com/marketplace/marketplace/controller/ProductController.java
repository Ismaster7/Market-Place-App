package com.marketplace.marketplace.controller;


import com.marketplace.marketplace.dtos.product.ProductRequest;
import com.marketplace.marketplace.dtos.product.ProductRequestPut;
import com.marketplace.marketplace.dtos.product.ProductResponse;
import com.marketplace.marketplace.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts (){

        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                .body(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct (@RequestBody @Valid ProductRequest productRequest){
       ProductResponse product = productService.saveProduct(productRequest);
       return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(product);
    }

    @PutMapping
    public  ResponseEntity<ProductResponse> updateProduct(
            @RequestBody @Valid ProductRequestPut productRequest){
       return ResponseEntity.status(HttpStatusCode.valueOf(200)).body( productService.updateProduct(productRequest));

    }
}
