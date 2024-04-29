package com.example.arquithexagonal.adapters.repositories;

import com.example.arquithexagonal.adapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepositoryJPA extends JpaRepository<ProductEntity, UUID> {
}
