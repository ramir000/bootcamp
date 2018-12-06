package com.api.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class CartId implements Serializable{
    private static final long serialVersionUID = 1229526746921764642L;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;
}