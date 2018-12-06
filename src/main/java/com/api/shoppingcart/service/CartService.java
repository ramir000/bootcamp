package com.api.shoppingcart.service;

import java.util.List;

import com.api.shoppingcart.model.Cart;
import com.api.shoppingcart.model.Product;
import com.api.shoppingcart.model.User;

public interface CartService {

	public List<Cart> addCart(List<Cart> cart);

	public List<Cart> getCart(Long userId);

	public List<Cart> updateCart(User userId, Product prodId, int quantity);

	public void removeCart(Long userId);

	public void removeProduct(User userId, Product prodId);

	public boolean exists(Long id);

	/*
	 * public Cart addProduct(long cartId, Node product);
	 * 
	 * public Cart removeProduct(long cartId, Node product);
	 */
}