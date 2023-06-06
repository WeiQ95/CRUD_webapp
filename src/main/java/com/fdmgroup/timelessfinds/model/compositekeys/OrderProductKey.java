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
