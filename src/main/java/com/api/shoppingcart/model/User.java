package com.api.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long userid;

    private String uname;

    public User(Long userId, String uname) {
        this.userid = userId;
        this.uname = uname;
    }

    public User() {
    }

    public Long getId() {
        return this.userid;
    }

    public void setId(Long id) {
        this.userid = id;
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}