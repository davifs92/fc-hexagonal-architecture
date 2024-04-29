package com.example.arquithexagonal.adapters.controllers;

import com.example.arquithexagonal.domain.Product;
import com.example.arquithexagonal.domain.dto.ProductDTO;
import com.example.arquithexagonal.intefaces.ProductInterface;
import com.example.arquithexagonal.intefaces.ProductServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServicePort productServicePort;


    public ProductController(ProductServicePort productServiceInterface) {
        this.productServicePort = productServiceInterface;
    }

    @PostMapping
    ResponseEntity<ProductInterface> createProduct(@RequestBody ProductDTO dto) throws Exception {

        ProductInterface response = productServicePort.create(dto.getName(), dto.getPrice());
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<ProductInterface> getProduct(@PathVariable String id) {
        ProductInterface response = productServicePort.get(id);
        return ResponseEntity.ok(response);
    }
}