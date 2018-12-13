package com.globant.bootcamp.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.globant.bootcamp.dao.exception.UserNullPointerException;
import com.globant.bootcamp.model.Cart;
import com.globant.bootcamp.model.Node;
import com.globant.bootcamp.model.Product;
import com.globant.bootcamp.model.User;

public class Mapper {

    public static NodeDto convert(Node node) {
        return new NodeDto(node.getnodeId(), convert(node.getProduct()), node.getQuantity());
    }

    public static Node convert(NodeDto node, Cart c) {
        return new Node(node.getId(), convert(node.getProduct()), c, node.getQuantity());
    }

    public static CartDto convert(Cart cart) {

        CartDto c = new CartDto(cart.getCartid().intValue(), convert(cart.getUser()), null);
        List<NodeDto> n = new LinkedList<>();
        n = cart.getItems().stream().map(p -> convert(p)).collect(Collectors.toList());
        c.setItems(n);
        return c;
    }

    public static Cart convert(CartDto cart) {
        if (cart.getUser() == null)
            throw new UserNullPointerException();
        Cart c = new Cart(new Long(cart.getId()), null, convert(cart.getUser()));
        List<Node> n = new LinkedList<>();
        n = cart.getItems().stream().map(p -> convert(p, c)).collect(Collectors.toList());
        c.setItems(n);
        return c;

    }

    public static ProductDto convert(Product product) {
        return new ProductDto(product.getId(), product.getPname(), product.getPrice());
    }

    public static Product convert(ProductDto product) {
        return new Product(product.getId(), product.getPname(), product.getPrice());
    }

    public static UserDto convert(User user) {
        return new UserDto(user.getId(), user.getUname());
    }

    public static User convert(UserDto user) {
        return new User(user.getId(), user.getUname());
    }

}
