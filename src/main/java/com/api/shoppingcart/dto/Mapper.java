package com.api.shoppingcart.dto;

import java.util.ArrayList;
import java.util.List;

import com.api.shoppingcart.model.Cart;
import com.api.shoppingcart.model.CartId;
import com.api.shoppingcart.model.Product;
import com.api.shoppingcart.model.User;;

public class Mapper {

    public static CartDto convert(List<Cart> cart) {
        List<NodeDto> n = new ArrayList<>();
        for (Cart c : cart) {
            n.add(new NodeDto(convert(c.getId().getProduct()), c.getQuantity()));
        }
        return new CartDto(convert(cart.get(0).getId().getUser()), n);
    }

    public static List<Cart> convert(CartDto cart) {
        List<Cart> l = new ArrayList<>();
        for (NodeDto n : cart.getItems()) {
            CartId id = new CartId(convert(n.getProduct()), convert(cart.getUser()));
            Cart c = new Cart(id, n.getQuantity());
            l.add(c);
        }
        return l;
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
