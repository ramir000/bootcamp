package com.api.shoppingcart.service;

import java.util.List;

import com.api.shoppingcart.model.User;

public interface UserService {

    public User addUser(User user);

    public User getUser(long id);

    public void removeUser(long id);

    public List<User> getAll();

    public boolean exists(Long id);
}