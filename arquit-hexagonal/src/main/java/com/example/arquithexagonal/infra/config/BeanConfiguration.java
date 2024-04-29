package com.example.arquithexagonal.infra.config;

import com.example.arquithexagonal.adapters.repositories.ProductPersistenceImpl;
import com.example.arquithexagonal.adapters.repositories.ProductRepositoryJPA;
import com.example.arquithexagonal.domain.ports.ProductPersistenceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ProductPersistenceInterface productPersistenceInterface(ProductRepositoryJPA productRepositoryJPA, ModelMapper modelMapper){
        return new ProductPersistenceImpl(productRepositoryJPA, modelMapper);
    }
}
