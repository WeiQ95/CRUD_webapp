package com.fdmgroup.timelessfinds.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID", unique = true)
	private long userID;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isAdmin")
	private boolean isAdmin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cartID")
	private Cart cart;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders = new ArrayList<Order>();

	public User() {
		super();
	}

	public User(long userID, String firstName, String lastName, String email, String username, String password,
			boolean isAdmin, Cart cart, List<Order> orders) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.cart = cart;
		this.orders = orders;
	}

	public long getUserID() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public Cart getCart() {
		return cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
