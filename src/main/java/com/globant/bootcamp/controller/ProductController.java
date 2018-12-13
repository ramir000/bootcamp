package com.globant.bootcamp.controller;

import java.util.List;

import com.globant.bootcamp.dto.ProductDto;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.*;

public interface ProductController {

        @ApiOperation(value = "View a list of available products")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "List successfully retrieved "),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public List<ProductDto> getproducts();

        @ApiOperation(value = "View a product by id", response = ProductDto.class)
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully retrieved"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ResponseEntity<ProductDto> getproductByIndex(Long id);

        @ApiOperation(value = "Insert new product")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully inserted"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
        public ProductDto addProduct(ProductDto product);

        @ApiOperation(value = "Change one product")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully updated"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

        public ResponseEntity<ProductDto> updateProduct(Long id, ProductDto product);

        @ApiOperation(value = "Delete a product")
        @ApiResponses(value = { @ApiResponse(code = 200, message = "Product successfully deleted"),
                        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

        public ResponseEntity<?> deleteProduct(long id);

}