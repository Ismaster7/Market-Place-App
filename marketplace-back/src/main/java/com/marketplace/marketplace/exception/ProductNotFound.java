package com.marketplace.marketplace.exception;

import com.marketplace.marketplace.model.Product;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String message){super(message);}
}
