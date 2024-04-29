package com.example.arquithexagonal.domain;

import com.example.arquithexagonal.intefaces.ProductInterface;
import com.example.arquithexagonal.utils.Constant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

public class Product implements ProductInterface {
    private UUID id;
    private String name;
    private float price;
    private String status;

    public Product(){}

    public Product(String name, float price) {
        this.id = UUID.randomUUID();
        this.status = Constant.DISABLED;
        this.name = name;
        this.price = price;

    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isValid() throws Exception {

        if(status.isBlank()){
            this.status = Constant.DISABLED;
        }
        if(!Objects.equals(status, Constant.ENABLED) && !Objects.equals(status, Constant.DISABLED)){
            throw new Exception("the status must be enabled or disabled");
        }
        if(price < 0) {
            throw new Exception("the price must be bigger than zero");
        }

        return validate();

    }

    public void enable() throws Exception {
        if(this.price > 0){
            this.status = Constant.ENABLED;
        } else {
            throw new Exception("The price must be greater than zero to enable the product");
        }
    }

    public void disable() throws Exception {
        if(this.price == 0){
            this.status = Constant.DISABLED;
        } else {
            throw new Exception("The price must be equal to zero to disable the product");
        }
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    private boolean validate(){
        if(this.price == 0){
            return false;
        }
        if(this.status.isEmpty()){
            return false;
        }
        if(this.id.toString().isEmpty()){
            return false;
        }
        if(this.status.isEmpty()){
            return false;
        }
        return true;
    }
}
