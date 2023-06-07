package com.fdmgroup.timelessfinds.service;

import org.springframework.stereotype.Service;

import com.fdmgroup.timelessfinds.model.jointables.CartProduct;
import com.fdmgroup.timelessfinds.repository.CartProductRepository;
import com.fdmgroup.timelessfinds.repository.CartRepository;

@Service
public class CartProductService {

	private final CartProductRepository cartProductRepository;
	private final CartRepository cartRepository;
	
	public CartProductService(CartProductRepository cartProductRepository, CartRepository cartRepository) {
		super();
		this.cartProductRepository = cartProductRepository;
		this.cartRepository = cartRepository;
	}

	public void addProductToCart(CartProduct cartProduct) {
		cartProductRepository.save(cartProduct);
	}
	
	
}
