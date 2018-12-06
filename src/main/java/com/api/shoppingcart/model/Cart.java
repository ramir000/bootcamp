package com.api.shoppingcart.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Cart {
    @Id
    @Embedded
    private CartId id;

    private int quantity;

    public Cart(CartId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Cart() {
    }
    
    public CartId getId() {
        return this.id;
    }
    @Transient
    public Long getUserId(){
        return this.getUserId();
    }

    public void setId(CartId id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}