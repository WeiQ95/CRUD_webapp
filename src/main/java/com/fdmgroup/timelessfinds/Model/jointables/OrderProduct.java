package com.fdmgroup.timelessfinds.model.jointables;

import com.fdmgroup.timelessfinds.model.Order;
import com.fdmgroup.timelessfinds.model.Product;
import com.fdmgroup.timelessfinds.model.compositekeys.OrderProductKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrdersProducts")
public class OrderProduct {

	@EmbeddedId
	private OrderProductKey id;
	
	@ManyToOne
	@MapsId("orderID")
	@JoinColumn(name = "fk_orderID")
	private Order order;
	
	@ManyToOne
	@MapsId("productID")
	@JoinColumn(name = "fk_productID")
	private Product product;
	
	@Column(name = "quantity")
	private int quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(OrderProductKey id, Order order, Product product, int quantity) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderProductKey getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(OrderProductKey id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
