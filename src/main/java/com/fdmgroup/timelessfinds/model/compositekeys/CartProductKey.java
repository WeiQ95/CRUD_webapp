package com.fdmgroup.timelessfinds.model.compositekeys;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CartProductKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cartID")
	private long cartID;
	
	@Column(name = "productID")
	private long productID;

	@Override
	public int hashCode() {
		return Objects.hash(cartID, productID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProductKey other = (CartProductKey) obj;
		return cartID == other.cartID && productID == other.productID;
	}
	
}
