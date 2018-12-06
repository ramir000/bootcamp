package com.api.shoppingcart.controller.implement;

import java.util.List;

import com.api.shoppingcart.controller.CartController;
import com.api.shoppingcart.dto.CartDto;
import com.api.shoppingcart.dto.NodeDto;
import com.api.shoppingcart.service.implement.CartServiceImpl;
import com.api.shoppingcart.service.implement.NodeServiceImpl;
import com.api.shoppingcart.service.implement.ProductServiceImpl;

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
        private NodeServiceImpl servNode;
        @Autowired
        private ProductServiceImpl servProduct;

        @PostMapping(value = "/cart", produces = { "application/json" })
        public CartDto addCart(@RequestBody CartDto cart) {
                if (cart.getItems() != null) {
                        List<NodeDto> items = cart.getItems();
                        for (NodeDto item : items) {
                                if (item.getNodeId() != null) {
                                        if (!servNode.getNode(item.getNodeId()).isPresent()) {
                                                if (!servProduct.exists(item.getProduct().getId()))
                                                        throw new RuntimeException("PRODUCT NOT FOUND");
                                        }
                                } else
                                        throw new RuntimeException("ITEM ID CAN'T BE NULL");
                        }

                }
                return servCart.addCart(cart);
        }

        @DeleteMapping(value = "/cart", produces = { "application/json" })
        public void deleteCart(@RequestBody Long id) {
                servCart.removeCart(id);
        }

        @GetMapping("/cart/{id}/")
        public ResponseEntity<CartDto> getCart(@PathVariable("id") Long id) {
                CartDto cart = servCart.getCart(id);
                if (cart == null)
                        return ResponseEntity.notFound().build();
                return ResponseEntity.ok(cart);
        }

        @PutMapping(value = "/cart/{id}/item/", produces = { "application/json" })
        public ResponseEntity<CartDto> addItem(@PathVariable("id") Long id, @RequestBody NodeDto item) {
                if (servCart.exists(id)) {
                        item = servNode.addNode(item, servCart.getCart(id));
                        return ResponseEntity.ok(servCart.addNode(id, item));
                } else
                        return ResponseEntity.notFound().build();
        }

        @PutMapping(value = "/cart/{id}/item/{itemId}", produces = { "application/json" })
        public ResponseEntity<NodeDto> updateItem(@PathVariable("id") Long id, @PathVariable("itemId") Long prodID,
                        @RequestBody int quantity) {
                if (servCart.exists(id) && servNode.exists(itemId)) {
                        return ResponseEntity.ok(servNode.updateNode(item));
                } else
                        return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/cart/{cartId}/item/{itemId}")
        public void deleteItem(@PathVariable("cartId") Long id, @PathVariable("itemId") Long itemId) {
                servNode.removeNode(itemId);
        }

}