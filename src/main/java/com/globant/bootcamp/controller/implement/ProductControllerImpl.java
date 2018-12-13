package com.globant.bootcamp.controller.implement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.globant.bootcamp.controller.ProductController;
import com.globant.bootcamp.dao.exception.ProductNotFoundException;
import com.globant.bootcamp.dto.ProductDto;
import com.globant.bootcamp.model.Product;
import com.globant.bootcamp.dto.Mapper;
import com.globant.bootcamp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

@RestController
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductService serv;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/api/v1/products", produces = { "application/json" })
    public List<ProductDto> getproducts() {
        return ((Stream<Product>) serv.getAll().stream()).map(p -> Mapper.convert(p)).collect(Collectors.toList());
    }

    @GetMapping(value = "/api/v1/product/{id}", produces = { "application/json" })
    public ResponseEntity<ProductDto> getproductByIndex(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(modelMapper.map(serv.getProduct(id), ProductDto.class));
        } catch (RuntimeException ex) {
            throw new ProductNotFoundException(id);
        }
    }

    @PostMapping("/api/v1/product")
    public ProductDto addProduct(@RequestBody ProductDto product) {
        return modelMapper.map(serv.addProduct(modelMapper.map(product, Product.class)), ProductDto.class);
    }

    @PutMapping("/api/v1/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto product) {
        if (serv.exists(id)) {
            return ResponseEntity
                    .ok(modelMapper.map(serv.updateProduct(modelMapper.map(product, Product.class)), ProductDto.class));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/v1/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {
        try {
            serv.removeProduct(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            throw new ProductNotFoundException(id);
        }
    }
}