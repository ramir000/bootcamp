package com.api.shoppingcart.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    @Embedded
    private CartId id;

    private int quantity;
}