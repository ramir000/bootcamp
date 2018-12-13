package com.globant.bootcamp.controller.implement;

import com.globant.bootcamp.controller.UserController;
import com.globant.bootcamp.dao.exception.UserNotFoundException;
import com.globant.bootcamp.dto.UserDto;
import com.globant.bootcamp.dto.Mapper;
import com.globant.bootcamp.model.User;
import com.globant.bootcamp.service.UserService;
import com.globant.bootcamp.service.implement.UserServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserServiceImpl serv;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/api/v1/user/")
    public UserDto addUser(@RequestBody UserDto user) {
        User user2 = modelMapper.map(user, User.class);
        return modelMapper.map(serv.addUser(user2), UserDto.class);
    }

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        /*
         * if (serv.exists(id)) return
         * ResponseEntity.ok(Mapper.convert(serv.getUser(id))); return
         * ResponseEntity.notFound().build();
         */
        try {
            return ResponseEntity.ok(Mapper.convert(serv.getUser(id)));
        } catch (RuntimeException ex) {
            throw new UserNotFoundException(id);
        }

    }
}