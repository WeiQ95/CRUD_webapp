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

	public CartProductKey() {
		super();
	}

	public CartProductKey(long cartID, long productID) {
		super();
		this.cartID = cartID;
		this.productID = productID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getCartID() {
		return cartID;
	}

	public long getProductID() {
		return productID;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

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
