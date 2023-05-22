package com.fdmgroup.timelessfinds.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Long cartId;
	
    @Column(name = "Cart_Date", nullable = false)
    private final Date cartDate = new Date();
	
	@OneToOne(mappedBy = "cart")
	@JoinColumn(name = "userId", unique = true)
	private User user;
	
	@ManyToMany
	@JoinTable(name="cart_product", joinColumns=
	@JoinColumn(name="fk_cart_id"), 	inverseJoinColumns=
	@JoinColumn(name="fk_product_id")
	) 
	private List<Product> products = new ArrayList<>();

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
	}
	
	public void updateProductinCart(Product product) {
		for (int i=0; i < products.size(); i++) {
			if(products.get(i).getProductId() == product.getProductId()) {
				products.set(i, product);
			}
		}
	}
	
	public String getListOfProduct() {
		String listOfItems = "";
		for (Product pdt: products) {
			listOfItems += pdt.getProductId() +": "+pdt.getName() +", "+ pdt.getPrice()+", "+ pdt.getQuantity() + "\n";
		}
		return listOfItems;
	}
	
	
}
