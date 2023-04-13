package com.fdmgroup.timelessfinds.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Long cartId;
	
    @Column(name = "Cart_Date", nullable = false)
    private Date cartDate;
	
	@OneToOne
	@JoinColumn(name = "order_id", unique = true)
	private Order order;
	
	@ManyToMany
	@JoinTable(name="cart_product", joinColumns=
	@JoinColumn(name="fk_cart_id"), 	inverseJoinColumns=
	@JoinColumn(name="fk_product_id")
	) 
	private List<Product> cart = new ArrayList<>();
	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	public void addProduct(Product product) {
		cart.add(product);
	}
	
	public void removeProduct(Product product) {
		cart.remove(product);
	}
	
	public void updateProductinCart(Product product) {
		for (int i=0; i < cart.size(); i++) {
			if(cart.get(i).getProductId() == product.getProductId()) {
				cart.set(i, product);
			}
		}
	}
	
	public String getListOfProduct() {
		String listOfItems = "";
		for (Product pdt: cart) {
			listOfItems += pdt.getProductId() +": "+pdt.getName() +", "+ pdt.getPrice()+", "+ pdt.getQuantity() + "\n";
		}
		return listOfItems;
	}
	
	
}
