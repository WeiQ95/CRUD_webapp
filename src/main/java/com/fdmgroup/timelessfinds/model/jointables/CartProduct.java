package com.fdmgroup.timelessfinds.model.jointables;

import com.fdmgroup.timelessfinds.model.Cart;
import com.fdmgroup.timelessfinds.model.Product;
import com.fdmgroup.timelessfinds.model.compositekeys.CartProductKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "CartsProducts")
public class CartProduct {

	@EmbeddedId
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
}
