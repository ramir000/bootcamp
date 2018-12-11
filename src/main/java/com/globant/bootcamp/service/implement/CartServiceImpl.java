package com.globant.bootcamp.service.implement;

import com.globant.bootcamp.dao.CartDao;
import com.globant.bootcamp.model.Cart;
import com.globant.bootcamp.model.Node;
import com.globant.bootcamp.model.Product;
import com.globant.bootcamp.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao repo;
	@Autowired
	private NodeServiceImpl servNode;

	public Cart addCart(Cart cart) {
		Cart c = repo.save(cart);
		for (Node n : c.getItems())
			servNode.add(n);
		return c;
	}

	public Cart getCart(Long cartid) {
		if (repo.existsById(cartid))
			return repo.getOne(cartid);
		else
			return null;
	}

	public Cart updateCart(Long cartid, Product prodId, int quantity) {
		Cart c = repo.getOne(cartid);
		for (Node n : c.getItems()) {
			if (n.getProduct().getId().equals(prodId.getId())) {
				servNode.update(n, quantity);
			}
		}
		return repo.save(c);
	}

	public void removeCart(Long cartId) {
		Cart c = repo.getOne(cartId);
		for (Node n : c.getItems())
			servNode.remove(n);
		repo.delete(c);
	}

	public boolean exists(Long id) {
		return repo.existsById(id);
	}

	@Override
	public void removeProduct(Long cartid, Product prodId) {
		Cart c = repo.getOne(cartid);
		for (Node n : c.getItems()) {
			if (n.getProduct().getId().equals(prodId.getId())) {
				servNode.remove(n);
			}
		}
	}

	@Override
	public Cart addItem(Long cartid, Node n) {
		Cart c = repo.getOne(cartid);
		n.setCart(c);
		servNode.add(n);
		c.additem(n);
		return repo.save(c);
	}
}