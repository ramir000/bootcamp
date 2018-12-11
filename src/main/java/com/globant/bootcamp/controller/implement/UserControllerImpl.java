package com.globant.bootcamp.controller.implement;

import com.globant.bootcamp.controller.UserController;
import com.globant.bootcamp.dto.UserDto;
import com.globant.bootcamp.model.User;
import com.globant.bootcamp.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService serv;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/api/v1/user/")
    public UserDto addUser(@RequestBody UserDto user) {
        User user2 = modelMapper.map(user, User.class);
        return modelMapper.map(serv.addUser(user2), UserDto.class);
    }

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        if (serv.exists(id))
            return ResponseEntity.ok(modelMapper.map(serv.getUser(id), UserDto.class));
        return ResponseEntity.notFound().build();
    }
}