package com.api.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NodeDto {

    private ProductDto product;
    private int quantity;

    public NodeDto() {
    }

    public NodeDto(ProductDto product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return this.product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Double getPrice() {
        return this.getProduct().getPrice() * this.quantity;
    }
}