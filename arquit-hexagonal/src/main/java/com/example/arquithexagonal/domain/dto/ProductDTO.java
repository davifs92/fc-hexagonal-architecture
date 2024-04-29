package com.example.arquithexagonal.domain.dto;

import com.example.arquithexagonal.intefaces.ProductInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDTO implements ProductInterface {

    private UUID id;
    private String name;
    private float price;
    private String status;
}
