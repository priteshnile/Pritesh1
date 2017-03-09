package com.spring.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	public class KartItem {
		private int itemid;
		private int quantity;
		private double price;
		private String name;
		private String imagepath;
		private String type;
		
		
	
		private Product product;
		private Category category;

		public KartItem() {
			
		}
		public KartItem(int itemid, int quantity, double price, String name, String imagepath, String type,
				Product product, Category category) {
			super();
			this.itemid = itemid;
			this.quantity = quantity;
			this.price = price;
			this.name = name;
			this.imagepath = imagepath;
			this.type = type;
			this.product = product;
			this.category = category;
		}
		

		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
	
		public int getItemid() {
			return itemid;
		}
		public void setItemid(int itemid) {
			this.itemid = itemid;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getImagepath() {
			return imagepath;
		}
		public void setImagepath(String imagepath) {
			//this.imagepath=path+this.imagepath;
			this.imagepath=imagepath;
			
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
}
