package com.fdmgroup.timelessfinds.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fdmgroup.timelessfinds.Model.Product;
import com.fdmgroup.timelessfinds.Repository.CartRepository;


@Service
public class CartService {

	private CartRepository cartRepository;
	
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    
    public List<Product> getListOfProducts(long cartId){
    	return cartRepository.findProductsInCartByID(cartId);
    }
    
    
    
    
    
    
    
}
