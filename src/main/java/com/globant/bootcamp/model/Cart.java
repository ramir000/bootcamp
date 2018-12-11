package com.globant.bootcamp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartid;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany
    private List<Node> items;

    public Cart(Long cartid, List<Node> items, User user) {
        this.cartid = cartid;
        this.items = items;
        this.user = user;
    }

    public Cart() {
    }

    /**
     * @return Long return the cartid
     */
    public Long getCartid() {
        return cartid;
    }

    /**
     * @param cartid the cartid to set
     */
    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }

    /**
     * @return List<Node> return the items
     */
    public List<Node> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Node> items) {
        this.items = items;
    }

    public void additem(Node n){
        this.items.add(n);
    }

    public void removeitem(Node n){
        this.items.remove(n);
    }
    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}