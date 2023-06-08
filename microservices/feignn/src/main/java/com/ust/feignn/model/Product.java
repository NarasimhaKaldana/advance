package com.ust.feignn.model;


	import java.math.BigDecimal;

	//import javax.persistence.Entity;
	//import javax.persistence.GeneratedValue;
	//import javax.persistence.GenerationType;
	//import javax.persistence.Id;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;



	@Data
	@AllArgsConstructor
	@NoArgsConstructor

	public class Product {
		
		private long ProductId;
		
		private String name;
		
		private String category;
		
		private String brand;
		
		private double price;
		

	}




