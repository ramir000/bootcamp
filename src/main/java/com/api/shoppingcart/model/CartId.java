package com.api.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class CartId implements Serializable {
    private static final long serialVersionUID = 1229526746921764642L;

    @OneToOne
    @JoinColumn(name = "productid")
    private Product product;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    public CartId() {
    }

    public CartId(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}