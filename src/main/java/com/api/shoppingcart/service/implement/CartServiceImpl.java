package com.api.shoppingcart.service.implement;

import java.util.List;

import com.api.shoppingcart.dao.CartDao;
import com.api.shoppingcart.model.Cart;
import com.api.shoppingcart.model.CartId;
import com.api.shoppingcart.model.Product;
import com.api.shoppingcart.model.User;
import com.api.shoppingcart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao repo;

	public List<Cart> addCart(List<Cart> cart) {
		for (Cart c : cart)
			repo.save(c);
		return repo.findAllByUserId(cart.get(0).getId().getUser().getId());
	}

	public List<Cart> getCart(Long userId) {
		if (repo.existsByUserId(userId) )
			return repo.findAllByUserId(userId);
		else
			return null;
	}

	public List<Cart> updateCart(User userId, Product prodId, int quantity) {
		CartId id = new CartId(prodId, userId);
		Cart c = repo.getOne(id);
		c.setQuantity(quantity);
		repo.save(c);
		return repo.findAllByUserId(userId.getId());
	}

	public void removeCart(Long cartId) {
		repo.deleteByUserId(cartId);
	}

	public boolean exists(Long id) {
		return repo.existsByUserId(id);
	}

	@Override
	public void removeProduct(User userId, Product prodId) {
		CartId id = new CartId(prodId, userId);
		repo.deleteById(id);
	}
}