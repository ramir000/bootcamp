package com.api.shoppingcart.service;

import java.util.List;

import com.api.shoppingcart.model.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public Product getProduct(long id);

	public Product updateProduct(Product product);
 
	public void removeProduct(long id);

	public List<Product> getAll();

	public boolean exists(Long id);
}