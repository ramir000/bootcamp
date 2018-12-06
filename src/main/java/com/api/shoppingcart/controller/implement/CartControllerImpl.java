package com.api.shoppingcart.controller.implement;

import java.util.LinkedList;
import java.util.List;

import com.api.shoppingcart.controller.CartController;
import com.api.shoppingcart.dto.CartDto;
import com.api.shoppingcart.dto.Mapper;
import com.api.shoppingcart.dto.NodeDto;
import com.api.shoppingcart.service.ProductService;
import com.api.shoppingcart.service.UserService;
import com.api.shoppingcart.service.implement.CartServiceImpl;
import com.api.shoppingcart.service.implement.ProductServiceImpl;

import org.modelmapper.ModelMapper;
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
        private UserService servUser;
        @Autowired
        private ProductService servProduct;
        @Autowired
        private ModelMapper modelMapper;

        @PostMapping(value = "/cart", produces = { "application/json" })
        public CartDto addCart(@RequestBody CartDto cart) {
                return Mapper.convert(servCart.addCart(Mapper.convert(cart)));
        }

        @DeleteMapping(value = "/cart", produces = { "application/json" })
        public void deleteCart(@RequestBody Long id) {
                servCart.removeCart(id);
        }

        @GetMapping("/cart/{id}/")
        public ResponseEntity<CartDto> getCart(@PathVariable("id") Long id) {
                CartDto cart = Mapper.convert(servCart.getCart(id));
                if (cart == null)
                        return ResponseEntity.notFound().build();
                return ResponseEntity.ok(cart);
        }

        @PutMapping(value = "/cart/{id}/product/", produces = { "application/json" })
        public ResponseEntity<CartDto> addItem(@PathVariable("id") Long id, @RequestBody NodeDto item) {
                if (servCart.exists(id)) {
                        List<NodeDto> n = new LinkedList<>();
                        n.add(item);
                        CartDto cart = new CartDto(Mapper.convert(servUser.getUser(id)), n);
                        return ResponseEntity.ok(Mapper.convert(servCart.addCart(Mapper.convert(cart))));
                } else
                        return ResponseEntity.notFound().build();
        }

        @PutMapping(value = "/cart/{id}/product/{productId}", produces = { "application/json" })
        public ResponseEntity<List<NodeDto>> updateItem(@PathVariable("id") Long id,
                        @PathVariable("productId") Long prodID, @RequestBody int quantity) {
                if (servCart.exists(id)) {
                        return ResponseEntity.ok(Mapper.convert(servCart.updateCart(servUser.getUser(id),
                                        servProduct.getProduct(prodID), quantity)).getItems());
                } else
                        return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/cart/{id}/item/{productId}")
        public void deleteItem(@PathVariable("id") Long id, @PathVariable("productId") Long prodID) {
                servCart.removeProduct(servUser.getUser(id), servProduct.getProduct(prodID));
        }

}