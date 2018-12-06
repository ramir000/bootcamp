package com.api.shoppingcart.service;

import java.util.List;

import com.api.shoppingcart.dto.ProductDto;

public interface ProductService {

	public ProductDto addProduct(ProductDto product);

	public ProductDto getProduct(long id);

	public ProductDto updateProduct(ProductDto product);
 
	public void removeProduct(long id);

	public List<ProductDto> getAll();

	public boolean exists(Long id);
}