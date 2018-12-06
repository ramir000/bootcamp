package com.api.shoppingcart.service.implement;

import java.util.List;

import com.api.shoppingcart.dao.CartDao;
import com.api.shoppingcart.dto.CartDto;
import com.api.shoppingcart.dto.NodeDto;
import com.api.shoppingcart.model.Cart;
import com.api.shoppingcart.service.CartService;
import com.api.shoppingcart.service.ConverterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private ConverterService converterService;
	@Autowired
	private CartDao repo;

	public CartDto addCart(CartDto cart) {
		return converterService.convert(repo.save(converterService.convert(cart)));
	}

	public CartDto addNode(Long cartId, NodeDto node) {
		Cart cart = repo.getOne(cartId);
		cart.addItem(converterService.convert(node, repo.getOne(cartId)));
		return converterService.convert(repo.save(cart));
	}

	public CartDto getCart(Long cartId) {
		if (repo.existsById(cartId))
			return converterService.convert(repo.getOne(cartId));
		else
			return null;
	}

	public List<CartDto> getAll() {
		return null;
	};

	public void removeCart(Long cartId) {
		repo.deleteById(cartId);
	}

	public boolean exists(Long id) {
		return repo.existsById(id);
	}

	/*
	 * public Cart addProduct(long cartId, Node product);
	 * 
	 * public Cart removeProduct(long cartId, Node product);
	 */
}