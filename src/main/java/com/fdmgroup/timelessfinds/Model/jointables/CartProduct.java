package com.fdmgroup.timelessfinds.model.jointables;

import com.fdmgroup.timelessfinds.model.Cart;
import com.fdmgroup.timelessfinds.model.Product;
import com.fdmgroup.timelessfinds.model.compositekeys.CartProductKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "CartsProducts")
public class CartProduct {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private CartProductKey id;
	
	@ManyToOne
	@MapsId("cartID")
	@JoinColumn(name = "fk_cartID")
	private Cart cart;
	
	@ManyToOne
	@MapsId("productID")
	@JoinColumn(name = "fk_productID")
	private Product product;
	
	@Column(name = "quantity")
	private int quantity;
	
	public CartProduct() {
		super();
	}

	public CartProduct(CartProductKey id, Cart cart, Product product, int quantity) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartProductKey getId() {
		return id;
	}

	public Cart getCart() {
		return cart;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(CartProductKey id) {
		this.id = id;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
