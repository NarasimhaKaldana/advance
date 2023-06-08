package com.ust.product.service;

import java.util.List;

import com.ust.product.resource.Product;

public interface ProductService {

		List<Product> findAll();
		List<Product> findByCategory(String category);
		Product findById(int id);
	
}
