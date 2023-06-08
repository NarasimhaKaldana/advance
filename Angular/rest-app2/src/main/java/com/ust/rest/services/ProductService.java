package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.repository.UserRepository;
import com.ust.rest.resource.Product;
import com.ust.rest.resource.User;



@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	
	public Product getProduct(long productId) {
		Optional<Product> optional =productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
//		return repository.getProduct(productId);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
		
	}
	
	@Transactional(propagation= Propagation.REQUIRED)
	public Product add(Product product) {
//		if(validate(product)) {
//			return false;
//		}else {
//			 productRepository.save(product);
//			 return true;
//		}
		
		Product productT= productRepository.save(product);
		User user = new User();
		user.setUserId(5L);
		user.setDateTime(System.currentTimeMillis()+"");
		User userT = userRepository.save(user);
		
//		System.out.println(userT);
//		if(userT != null && productT != null) {
//			return true;
//		}else {
//			throw new RuntimeException("record not inserted");
//		}
		
		return productT;

		
	}
	
	
	public Product updateProduct(Product product) {
     Optional<Product> optional = productRepository.findById(product.getProductId());
     Product tempProduct = optional.get();
     tempProduct.setName(product.getName());
     tempProduct.setDescription(product.getDescription());
     tempProduct.setPrice(product.getPrice());
     tempProduct.setQty(product.getQty());
		return productRepository.save(tempProduct);
	}
	
	
	public void deleteProduct(long productId) {
		productRepository.deleteById(productId);
	}
	
//	public boolean validate(Product product) {
//		if(product.getName().equals("WM")) {
//			return true;
//			
//		}else {
//			return false;
//		}
//	}

}
















