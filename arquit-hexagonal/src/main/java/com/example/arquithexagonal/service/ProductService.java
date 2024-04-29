package com.example.arquithexagonal.service;

import com.example.arquithexagonal.domain.Product;
import com.example.arquithexagonal.domain.dto.ProductDTO;
import com.example.arquithexagonal.intefaces.ProductInterface;
import com.example.arquithexagonal.domain.ports.ProductPersistenceInterface;
import com.example.arquithexagonal.intefaces.ProductServicePort;
import com.example.arquithexagonal.utils.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.ResourceAccessException;

import java.util.UUID;

public class ProductService implements ProductServicePort {

    private final ProductPersistenceInterface persistence;
    private final ModelMapper modelMapper;

   public ProductService(ProductPersistenceInterface persistence, ModelMapper modelMapper) {
        this.persistence = persistence;
       this.modelMapper = modelMapper;
   }

    @Override
    public ProductInterface get(String id) {
        ProductInterface product = persistence.get(id);
        if(product == null){
            throw new ResourceAccessException("fail to retrieve the product");
        }

        return modelMapper.map(product, ProductDTO.class);

    }

    @Override
    public ProductInterface create(String name, float price) throws Exception {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(name);
        product.setPrice(price);
        product.setStatus(Constant.DISABLED);
        if(!product.isValid()){
            return new Product();
        }
        ProductInterface saved = persistence.save(product);
        return modelMapper.map(saved, ProductDTO.class);
    }

    @Override
    public ProductInterface enable(Product product) throws Exception {
        product.enable();
        return persistence.save(product);
    }

    @Override
    public ProductInterface disable(ProductInterface product) {
        return null;
    }
}
