package com.spring.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	@Entity
	@Table(name="item")
	public class Item {

		@Id
		@Column(name="itemid")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int itemid;
		private double price;
		private String name;
		private String imagepath;
		private String type;
		
		//private static final String path="/images/";
		
		@ManyToOne(cascade=CascadeType.ALL, targetEntity=Product.class)
		@JoinColumn(name="productid", referencedColumnName="productid")
		private Product product;

		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		@ManyToOne(cascade=CascadeType.ALL, targetEntity=Category.class)
		@JoinColumn(name="categoryid", referencedColumnName="categoryid")
		private Category category;

		
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
}
