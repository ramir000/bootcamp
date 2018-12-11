package com.globant.bootcamp.service;

import com.globant.bootcamp.model.Node;
import com.globant.bootcamp.model.Cart;
import com.globant.bootcamp.model.Product;

public interface CartService {

	public Cart addCart(Cart cart);

	public Cart addItem(Long cartid, Node n);

	public Cart getCart(Long userId);

	public Cart updateCart(Long id, Product prodId, int quantity);

	public void removeCart(Long userId);

	public void removeProduct(Long cartid, Product prodId);

	public boolean exists(Long id);
}