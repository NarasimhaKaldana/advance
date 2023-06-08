package com.ust.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.resource.Product;

@SpringBootApplication
public class FirstRestApplication implements CommandLineRunner {

	@Autowired
	ProductRepository repo;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt=SpringApplication.run(FirstRestApplication.class, args);
		for(String str:args) {
			System.out.println(str);
		}
		boolean str = ctxt.containsBean("userrepository");
		System.out.println(str);
	}
@Override 
public void run(String...args) throws Exception {
	System.out.println("FromCommandLineRunner");
	
	List<Product> products = repo.findAll();
	System.out.println(products.size());
}
}
