package com.fdmgroup.timelessfinds.model;

import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.timelessfinds.model.jointables.CartProduct;
import com.fdmgroup.timelessfinds.model.jointables.OrderProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productID")
	private long productID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	private int inventoryQuantity;
	
	@Column(name = "image")
	private String imageUrl;
	
	@OneToMany(mappedBy = "product")
	private Set<CartProduct> addedToCarts = new HashSet<>();
	
	@OneToMany(mappedBy = "product")
	private Set<OrderProduct> ordered = new HashSet<>();
	
	public Product() {
		super();
	}

	public Product(long productID, String name, String description, String category, double price,
			int inventoryQuantity, String imageUrl, Set<CartProduct> addedToCarts, Set<OrderProduct> ordered) {
		super();
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.inventoryQuantity = inventoryQuantity;
		this.imageUrl = imageUrl;
		this.addedToCarts = addedToCarts;
		this.ordered = ordered;
	}

	public long getProductID() {
		return productID;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Set<CartProduct> getAddedToCarts() {
		return addedToCarts;
	}

	public Set<OrderProduct> getOrdered() {
		return ordered;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setAddedToCarts(Set<CartProduct> addedToCarts) {
		this.addedToCarts = addedToCarts;
	}

	public void setOrdered(Set<OrderProduct> ordered) {
		this.ordered = ordered;
	}
}