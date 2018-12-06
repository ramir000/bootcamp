package com.api.shoppingcart.service;

import java.util.LinkedList;
import java.util.List;

import com.api.shoppingcart.dto.*;
import com.api.shoppingcart.model.*;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public User convert(UserDto user) {
        return new User(user.getId(), user.getUname());
    }

    public UserDto convert(User user) {
        return new UserDto(user.getId(), user.getUname());
    }

    public Product convert(ProductDto Product) {
        return new Product(Product.getId(), Product.getPname(), Product.getPrice());
    }

    public ProductDto convert(Product Product) {
        return new ProductDto(Product.getId(), Product.getPname(), Product.getPrice());
    }

    public Node convert(NodeDto node, Cart cart) {
        return new Node(node.getNodeId(), convert(node.getProduct()), node.getQuantity(), cart);
    }

    public NodeDto convert(Node node) {
        return new NodeDto(node.getNodeId(), convert(node.getProduct()), node.getQuantity());
    }

    public Cart convert(CartDto cart) {
        Cart _cart;
        if (cart.getUser() == null)
            _cart = new Cart(cart.getCartId(), null, null);
        else
            _cart = new Cart(cart.getCartId(), convert(cart.getUser()), null);
        List<Node> n = new LinkedList<>();
        for (NodeDto node : cart.getItems())
            n.add(convert(node, _cart));
        _cart.setItems(n);
        return _cart;
    }

    public CartDto convert(Cart cart) {
        List<NodeDto> n = new LinkedList<>();
        for (Node node : cart.getItems())
            n.add(convert(node));
            if (cart.getUser() == null)
        return new CartDto(cart.getCartId(), null, n);
        else return new CartDto(cart.getCartId(), convert(cart.getUser()), n);
    }
}