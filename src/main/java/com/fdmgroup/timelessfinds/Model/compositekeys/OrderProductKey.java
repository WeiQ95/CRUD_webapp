package com.fdmgroup.timelessfinds.model.compositekeys;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderProductKey {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "orderID")
	private long orderID;
	
	@Column(name = "productID")
	private long productID;

	public OrderProductKey() {
		super();
	}

	public OrderProductKey(long orderID, long productID) {
		super();
		this.orderID = orderID;
		this.productID = productID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getOrderID() {
		return orderID;
	}

	public long getProductID() {
		return productID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderID, productID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProductKey other = (OrderProductKey) obj;
		return orderID == other.orderID && productID == other.productID;
	}
	
}
