package com.fdmgroup.timelessfinds.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.timelessfinds.model.jointables.OrderProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderID")
	private long orderID;
	
	@Column(name = "orderDate")
	private Date orderDate;
	
	@Column(name = "grandTotal")
	private double grandTotal;
	
	@ManyToOne
	@JoinColumn(name = "fk_userID")
	private User user;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderProduct> products = new HashSet<>();
	
//	@ManyToMany
//	@JoinTable(
//			name = "OrdersProducts", 
//			joinColumns = @JoinColumn(name = "fk_orderID"),
//			inverseJoinColumns = @JoinColumn(name = "fk_productID"))
//	private List<Product> products = new ArrayList<>();

	public Order() {
		super();
	}

	public Order(long orderID, Date orderDate, double grandTotal, User user, Set<OrderProduct> products) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.grandTotal = grandTotal;
		this.user = user;
		this.products = products;
	}

	public long getOrderID() {
		return orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public User getUser() {
		return user;
	}

	public Set<OrderProduct> getProducts() {
		return products;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setProducts(Set<OrderProduct> products) {
		this.products = products;
	}
}
