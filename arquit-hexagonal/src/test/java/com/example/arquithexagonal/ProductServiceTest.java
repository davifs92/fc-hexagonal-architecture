package com.example.arquithexagonal;

import com.example.arquithexagonal.domain.Product;
import com.example.arquithexagonal.intefaces.ProductInterface;
import com.example.arquithexagonal.domain.ports.ProductPersistenceInterface;
import com.example.arquithexagonal.intefaces.ProductServicePort;
import com.example.arquithexagonal.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private ProductServicePort productService;
    @Mock
    private ProductPersistenceInterface persistence;
    @MockBean
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp(){
        this.persistence = mock(ProductPersistenceInterface.class);
        this.productService = new ProductService(persistence, modelMapper);

    }

    @Test
    void testProductServiceGet(){
        Product product = new Product("abc", 1);
        when(persistence.get(any())).thenReturn(product);
        ProductInterface result = productService.get(product.getId().toString());

        assertEquals(result, product);

    }

    @Test
    void testProductServiceCreate() throws Exception {
        Product product = new Product("abc", 1);
        when(persistence.save(any())).thenReturn(product);
        ProductInterface result = productService.create(product.getName(), product.getPrice());

        assertEquals(result, product);

    }

    @Test
    void testProductServiceEnable() throws Exception {
        Product product = new Product("abc", 1);
        product.enable();
        when(persistence.save(any())).thenReturn(product);
        ProductInterface result = productService.enable(product);
        assertEquals(result, product);

    }
}
