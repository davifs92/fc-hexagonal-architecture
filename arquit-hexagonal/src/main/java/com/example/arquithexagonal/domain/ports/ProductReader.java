package com.example.arquithexagonal.domain.ports;

import com.example.arquithexagonal.domain.dto.ProductDTO;
import com.example.arquithexagonal.intefaces.ProductInterface;

public interface ProductReader {

    ProductInterface get(String id);
}
