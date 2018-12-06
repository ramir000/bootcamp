package com.api.shoppingcart.controller.implement;

import java.util.List;

import com.api.shoppingcart.controller.ProductController;
import com.api.shoppingcart.dto.ProductDto;
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
        return serv.getAll();
    }

    @GetMapping(value = "/product/{id}", produces = { "application/json" })
    public ResponseEntity<ProductDto> getproductByIndex(@PathVariable Long id) {
        if (serv.exists(id))
            return ResponseEntity.ok(serv.getProduct(id));
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/product")
    public ProductDto addProduct(@RequestBody ProductDto product) {
        return serv.addProduct(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto product) {
        if (serv.exists(id)) {
            
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable long id) {
    
    }
}