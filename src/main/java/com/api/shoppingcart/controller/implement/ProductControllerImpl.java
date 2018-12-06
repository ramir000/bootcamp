package com.api.shoppingcart.controller.implement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.api.shoppingcart.controller.ProductController;
import com.api.shoppingcart.dto.ProductDto;
import com.api.shoppingcart.model.Product;
import com.api.shoppingcart.dto.Mapper;
import com.api.shoppingcart.service.ProductService;
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

    @GetMapping(value = "/product", produces = { "application/json" })
    public List<ProductDto> getproducts() {
        return ((Stream<Product>) serv.getAll().stream()).map(p -> Mapper.convert(p)).collect(Collectors.toList());
    }

    @GetMapping(value = "/product/{id}", produces = { "application/json" })
    public ResponseEntity<ProductDto> getproductByIndex(@PathVariable Long id) {
        if (serv.exists(id))
            return ResponseEntity.ok(modelMapper.map(serv.getProduct(id), ProductDto.class));
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/product")
    public ProductDto addProduct(@RequestBody ProductDto product) {
        return modelMapper.map(serv.addProduct(modelMapper.map(product, Product.class)), ProductDto.class);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto product) {
        if (serv.exists(id)) {
            return ResponseEntity
                    .ok(modelMapper.map(serv.updateProduct(modelMapper.map(product, Product.class)), ProductDto.class));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable long id) {
        serv.removeProduct(id);
    }
}