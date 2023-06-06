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
}
