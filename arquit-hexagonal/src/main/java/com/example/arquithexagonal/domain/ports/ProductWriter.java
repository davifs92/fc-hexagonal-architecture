package com.example.arquithexagonal.domain.ports;

import com.example.arquithexagonal.intefaces.ProductInterface;

public interface ProductWriter {

    ProductInterface save(ProductInterface product);
}
