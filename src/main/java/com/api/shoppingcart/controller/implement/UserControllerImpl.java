package com.api.shoppingcart.controller.implement;


import com.api.shoppingcart.controller.UserController;
import com.api.shoppingcart.dto.UserDto;
import com.api.shoppingcart.model.User;
import com.api.shoppingcart.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService serv;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    public UserDto addUser(@RequestBody UserDto user) {
        User user2 = modelMapper.map(user, User.class);
        return serv.addUser(user2);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        if (serv.exists(id))
            return ResponseEntity.ok(serv.getUser(id));
        return ResponseEntity.notFound().build();
    }
}