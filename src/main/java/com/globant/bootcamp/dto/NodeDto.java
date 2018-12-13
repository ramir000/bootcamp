package com.globant.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDto {

    private long id;
    private ProductDto product;
    private int quantity;

    @JsonIgnore
    public Double getPrice() {
        return this.getProduct().getPrice() * this.quantity;
    }

}