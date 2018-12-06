package com.api.shoppingcart.service;

import java.util.List;

import com.api.shoppingcart.dto.UserDto;

public interface UserService {

    public UserDto addUser(User user);

    public UserDto getUser(long id);

    public void removeUser(long id);

    public List<UserDto> getAll();

    public boolean exists(Long id);
}