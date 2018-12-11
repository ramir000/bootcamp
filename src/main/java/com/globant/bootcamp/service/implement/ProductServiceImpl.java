package com.globant.bootcamp.service.implement;

import java.util.LinkedList;
import java.util.List;
import com.globant.bootcamp.dao.ProductDao;
import com.globant.bootcamp.model.Product;
import com.globant.bootcamp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao repo;

	public Product addProduct(Product product) {
		return repo.save(product);
	};

	public Product getProduct(long id) {
		return repo.getOne(id);
	};

	public void removeProduct(long id) {
		repo.deleteById(id);
	}

	public List<Product> getAll() {
		List<Product> res = new LinkedList<>();
		for (Product p : repo.findAll())
			res.add(p);
		return res;
	};

	public boolean exists(Long id) {
		return repo.existsById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		Product u = repo.getOne(product.getId());
		u.setPname(product.getPname());
		u.setPrice(product.getPrice());
		return repo.save(u);

	}
}