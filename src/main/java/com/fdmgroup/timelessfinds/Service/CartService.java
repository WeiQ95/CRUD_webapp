package com.fdmgroup.timelessfinds.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.timelessfinds.model.Cart;
import com.fdmgroup.timelessfinds.model.Product;
import com.fdmgroup.timelessfinds.repository.CartRepository;

@Service
public class CartService {

	private final CartRepository  cartRepository;

	public CartService(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}
	
	public Cart findById(long cartID) {
		Optional<Cart> cartOfInterest = cartRepository.findById(cartID);
		if (cartOfInterest != null) {
			return cartOfInterest.get();
		}
		return new Cart();
	}
}
