package com.globant.bootcamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nodeId;

    @OneToOne
    @JoinColumn(name = "productid")
    private Product product;

    @ManyToOne
    private Cart cart;

    private int quantity;

    public Node(Long nodeId, Product product, Cart cart, int quantity) {
        this.nodeId = nodeId;
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }

    public Node(){}
    /**
     * @return Long return the Nodeid
     */
    public Long getnodeId() {
        return nodeId;
    }

    /**
     * @param Nodeid the Nodeid to set
     */
    public void setnodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return Product return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return Cart return the cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * @return int return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}