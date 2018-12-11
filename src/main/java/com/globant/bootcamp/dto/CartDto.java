package com.globant.bootcamp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

public class CartDto {
    private int id;
    private UserDto user;
    private List<NodeDto> items;

    public CartDto() {
    }

    public CartDto(int id, UserDto user, List<NodeDto> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    public UserDto getUser() {
        return this.user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<NodeDto> getItems() {
        return this.items;
    }

    public void setItems(List<NodeDto> items) {
        this.items = items;
    }

    public void addItem(NodeDto node) {
        this.items.add(node);
    }

    public void removeItem(NodeDto node) {
        this.items.remove(node);
    }

    public void removeAll() {
        this.items.removeAll(this.items);
    }

    @JsonIgnore
    public Double getTotal() {
        Double total = new Double(0);
        for (NodeDto item : this.items)
            total = total + item.getPrice();
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}