package com.api.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long poductid;
    private String Pname;
    private Double price;

    public Product() {
    }

    public Product(Long id, String Pname, Double price) {
        this.poductid = id;
        this.Pname = Pname;
        this.price = price;
    }

    public Long getId() {
        return this.poductid;
    }

    public void setId(Long id) {
        this.poductid = id;
    }

    public String getPname() {
        return this.Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}