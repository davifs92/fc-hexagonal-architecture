package com.example.arquithexagonal.intefaces;

import com.example.arquithexagonal.domain.Product;

public interface ProductServicePort {
    ProductInterface get(String id);
    ProductInterface create(String name, float price) throws Exception;
    ProductInterface enable(Product product) throws Exception;
    ProductInterface disable(ProductInterface product);

}
