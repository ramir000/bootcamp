package com.api.shoppingcart.service.implement;

import java.util.LinkedList;
import java.util.List;
import com.api.shoppingcart.dao.ProductDao;
import com.api.shoppingcart.dto.ProductDto;
import com.api.shoppingcart.model.Product;
import com.api.shoppingcart.service.ConverterService;
import com.api.shoppingcart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ConverterService converterService;
	@Autowired
	private ProductDao repo;

	public ProductDto addProduct(ProductDto product) {
		return converterService.convert(repo.save(converterService.convert(product)));
	};

	public ProductDto getProduct(long id) {
		return converterService.convert(repo.getOne(id));
	};

	public void removeProduct(long id) {
	}

	public List<ProductDto> getAll() {
		List<ProductDto> res = new LinkedList<>();
		for (Product p : repo.findAll())
			res.add(converterService.convert(p));
		return res;
	};

	public boolean exists(Long id) {
		return repo.existsById(id);
	}

	@Override
	public ProductDto updateProduct(ProductDto product) {
		Product u = repo.getOne(product.getId());
		u.setPname(product.getPname());
		u.setPrice(product.getPrice());
		return converterService.convert(repo.save(u));

	}
}