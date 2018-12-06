package com.api.shoppingcart.service;

import java.util.List;

import com.api.shoppingcart.dto.CartDto;
import com.api.shoppingcart.dto.NodeDto;

public interface CartService {

	public CartDto addCart(CartDto cart);
	
	public CartDto addNode(Long cartId, NodeDto node);

	public CartDto getCart(Long cartId);

	public List<CartDto> getAll();

	public void removeCart(Long cartId);

	public boolean exists(Long id);
    /*
	public Cart addProduct(long cartId, Node product);

	public Cart removeProduct(long cartId, Node product);
    */
}