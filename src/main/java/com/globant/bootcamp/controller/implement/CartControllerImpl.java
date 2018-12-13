package com.globant.bootcamp.controller.implement;

import java.util.List;

import com.globant.bootcamp.controller.CartController;
import com.globant.bootcamp.dto.CartDto;
import com.globant.bootcamp.dto.Mapper;
import com.globant.bootcamp.dto.NodeDto;
import com.globant.bootcamp.service.ProductService;
import com.globant.bootcamp.service.implement.CartServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

@RestController
@Api(value = "Online Shopping cart", description = "Operations pertaining to products in Online Store")
public class CartControllerImpl implements CartController {

        @Autowired
        private CartServiceImpl servCart;
        @Autowired
        private ProductService servProduct;

        @PostMapping(value = "/api/v1/cart", produces = { "application/json" })
        public CartDto addCart(@RequestBody CartDto cart) {
                return Mapper.convert(servCart.addCart(Mapper.convert(cart)));
        }

        @DeleteMapping(value = "/api/v1/cart", produces = { "application/json" })
        public void deleteCart(@RequestBody Long id) {
                servCart.removeCart(id);
        }

        @GetMapping("/api/v1/cart/{id}/")
        public ResponseEntity<CartDto> getCart(@PathVariable("id") Long id) {
                CartDto cart = Mapper.convert(servCart.getCart(id));
                if (cart == null)
                        return ResponseEntity.notFound().build();
                return ResponseEntity.ok(cart);

        }

        @GetMapping(value = "/api/v1/cart/{id}/products/", produces = { "application/json" })
        public ResponseEntity<List<NodeDto>> getItems(@PathVariable("id") Long id) {
                if (servCart.exists(id)) {
                        return ResponseEntity.ok(Mapper.convert(servCart.getCart(id)).getItems());
                } else
                        return ResponseEntity.notFound().build();
        }

        @PutMapping(value = "/api/v1/cart/{id}/product/", produces = { "application/json" })
        public ResponseEntity<CartDto> addItem(@PathVariable("id") Long id, @RequestBody NodeDto item) {
                if (servCart.exists(id)) {

                        return ResponseEntity.ok(Mapper.convert(servCart.addItem(id, Mapper.convert(item, null))));
                } else
                        return ResponseEntity.notFound().build();
        }

        @PutMapping(value = "/api/v1/cart/{id}/product/{productId}", produces = { "application/json" })
        public ResponseEntity<List<NodeDto>> updateItem(@PathVariable("id") Long id,
                        @PathVariable("productId") Long prodID, @RequestBody int quantity) {
                if (servCart.exists(id)) {
                        return ResponseEntity.ok(Mapper
                                        .convert(servCart.updateCart(id, servProduct.getProduct(prodID), quantity))
                                        .getItems());
                } else
                        return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/api/v1/cart/{id}/product/{productId}")
        public void deleteItem(@PathVariable("id") Long id, @PathVariable("productId") Long prodID) {
                servCart.removeProduct(id, servProduct.getProduct(prodID));
        }

}