package com.ust.product.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	


	public class Product {
		
		private long ProductId;
		
		private String name;
		
		private String category;
		
		private String brand;
		
		private double price;

		public Product(long productId, String name, String category, String brand, double price) {
			super();
			ProductId = productId;
			this.name = name;
			this.category = category;
			this.brand = brand;
			this.price = price;
		}

		public long getProductId() {
			return ProductId;
		}

		public void setProductId(long productId) {
			ProductId = productId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
		

		

	
}
