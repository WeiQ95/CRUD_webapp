package com.fdmgroup.timelessfinds.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="category")
	private String category;
	
	@Column(name="quantity")
	private int quantity;

	@Column(name="image")
	private String imageUrl;
	
	@ManyToMany(mappedBy = "products")
	private List<Cart> carts = new ArrayList<>();
	
	//Constructors
	public Product() {
		super();
	}

	public Product(String name, String description, double price, String category, int quantity, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
	}


	//Getters and Setters
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
