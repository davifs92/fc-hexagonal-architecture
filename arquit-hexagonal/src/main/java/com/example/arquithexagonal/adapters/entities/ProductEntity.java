package com.example.arquithexagonal.adapters.entities;

import com.example.arquithexagonal.intefaces.ProductInterface;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
@Entity
@Table(name = "tb_product")
public class ProductEntity {
    @Id
    private UUID id;
    private String name;
    private float price;
    private String status;
}
