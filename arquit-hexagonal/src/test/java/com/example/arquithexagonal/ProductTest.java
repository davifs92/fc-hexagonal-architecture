package com.example.arquithexagonal;

import com.example.arquithexagonal.domain.Product;
import com.example.arquithexagonal.utils.Constant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ProductTest {

    @Test
    void testProductEnable() throws Exception {
        Product product = new Product();
        product.setName("Hello");
        product.setPrice(10);
        product.setStatus(Constant.DISABLED);

        product.enable();

        Assertions.assertEquals(Constant.ENABLED, product.getStatus());

        product.setPrice(0);

        Assertions.assertThrows(Exception.class, () -> product.enable());

    }
    @Test
    void testProductDisable() throws Exception {
        Product product = new Product();
        product.setName("Hello");
        product.setPrice(0);
        product.setStatus(Constant.ENABLED);

        product.disable();

        Assertions.assertEquals(Constant.DISABLED, product.getStatus());

        product.setPrice(10);

        Assertions.assertThrows(Exception.class, () -> product.disable());


    }

    @Test
    void testProductIsValid() throws Exception {
        Product product = new Product();
        product.setName("Hello");
        product.setPrice(10);
        product.setStatus(Constant.DISABLED);
        product.setId(UUID.randomUUID());

        Assertions.assertEquals(true, product.isValid());

        product.setStatus("INVALID");

       Assertions.assertThrows(Exception.class, () -> product.disable());



    }




}
