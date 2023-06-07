package com.fdmgroup.timelessfinds.model;

import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.timelessfinds.model.jointables.CartProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartID", unique = true)
	private long cartID;
	
	@Column(name = "isReconciled")
	private boolean isReconciled;
	
	@OneToOne
	@JoinColumn(name = "fk_userID")
	private User user;
	
	@OneToMany(mappedBy = "cart")
	private Set<CartProduct> products = new HashSet<>();

	public Cart() {
		super();
	}

	public Cart(long cartID, boolean isReconciled, User user, Set<CartProduct> products) {
		super();
		this.cartID = cartID;
		this.isReconciled = isReconciled;
		this.user = user;
		this.products = products;
	}

	public long getCartID() {
		return cartID;
	}

	public boolean isReconciled() {
		return isReconciled;
	}

	public User getUser() {
		return user;
	}

	public Set<CartProduct> getProducts() {
		return products;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public void setReconciled(boolean isReconciled) {
		this.isReconciled = isReconciled;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setProducts(Set<CartProduct> products) {
		this.products = products;
	}
	
	public void addProducts(CartProduct product) {
		this.products.add(product);
	}
}
