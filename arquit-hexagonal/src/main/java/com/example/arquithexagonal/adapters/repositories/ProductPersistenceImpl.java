package com.example.arquithexagonal.adapters.repositories;

import com.example.arquithexagonal.adapters.entities.ProductEntity;
import com.example.arquithexagonal.domain.Product;
import com.example.arquithexagonal.domain.dto.ProductDTO;
import com.example.arquithexagonal.domain.ports.ProductPersistenceInterface;
import com.example.arquithexagonal.intefaces.ProductInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductPersistenceImpl implements ProductPersistenceInterface {

    private final ProductRepositoryJPA productRepositoryJPA;
    private final ModelMapper modelMapper;
    @Autowired
    public ProductPersistenceImpl(ProductRepositoryJPA productRepositoryJPA, ModelMapper modelMapper) {
        this.productRepositoryJPA = productRepositoryJPA;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductInterface get(String id) {
        ProductEntity entity = new ProductEntity();
        if(!id.isBlank()){
           entity = productRepositoryJPA.findById(UUID.fromString(id)).get();
        }

        return modelMapper.map(entity, Product.class);
    }

    @Override
    public ProductInterface save(ProductInterface product) {
            ProductEntity entity = modelMapper.map(product, ProductEntity.class);
            productRepositoryJPA.save(entity);
        return modelMapper.map(entity, Product.class);
    }
}
