package com.api.shoppingcart.controller;

import java.util.List;

import com.api.shoppingcart.controller.CartController;
import com.api.shoppingcart.dto.CartDto;
import com.api.shoppingcart.dto.NodeDto;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.*;

public interface CartController {

        @ApiOperation(value = "Add a new Cart")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully inserted"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public CartDto addCart(CartDto Cart);

        @ApiOperation(value = "Delete the current list")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully Deleted"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public void deleteCart(Long id);

        @ApiOperation(value = "Get a cart")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully changed"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ResponseEntity<CartDto> getCart(Long id);

        @ApiOperation(value = "Add a Product in a Cart")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "List successfully retrieved "),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ResponseEntity<CartDto> addItem(Long id, NodeDto item);

        @ApiOperation(value = "Change a Product")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "List successfully retrieved "),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ResponseEntity<List<NodeDto>> updateItem(Long id, Long prodID, int quantity);

        @ApiOperation(value = "Delete a Product in the Cart")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully Deleted"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public void deleteItem(Long id, Long prodID);
        

}