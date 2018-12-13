package com.globant.bootcamp.controller;

import java.util.List;

import com.globant.bootcamp.dto.UserDto;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.*;

public interface UserController {

        @ApiOperation(value = "Add a new user")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "User successfully added "),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public UserDto addUser(UserDto user);

        @ApiOperation(value = "View a user", response = UserDto.class)
        @ApiResponses(value = { @ApiResponse(code = 200, message = "User successfully retrieved "),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ResponseEntity<UserDto> getUser(Long id);

        @ApiOperation(value = "View all users", response = UserDto.class)
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Users successfully retrieved "),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ResponseEntity<List<UserDto>> getAll();

        @ApiOperation(value = "Delete a user", response = UserDto.class)
        @ApiResponses(value = { @ApiResponse(code = 200, message = "User successfully Deleted "),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ResponseEntity<?> removeUser(Long id);
}