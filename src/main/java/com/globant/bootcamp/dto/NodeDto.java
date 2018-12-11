package com.globant.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


public  class NodeDto {

    private long id;
    private ProductDto product;
    private int quantity;

    public NodeDto() {
    }

    public NodeDto(Long id,ProductDto product, int quantity) {
        this.id = id;
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

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

}