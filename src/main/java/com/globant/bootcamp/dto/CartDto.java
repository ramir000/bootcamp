package com.globant.bootcamp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto {
    private int id;
    private UserDto user;
    private List<NodeDto> items;

    public void addItem(NodeDto node) {
        this.items.add(node);
    }

    public void removeItem(NodeDto node) {
        this.items.remove(node);
    }

    @JsonIgnore
    public Double getTotal() {
        Double total = new Double(0);
        for (NodeDto item : this.items)
            total = total + item.getPrice();
        return total;
    }


}