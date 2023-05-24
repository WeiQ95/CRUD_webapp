package com.fdmgroup.timelessfinds.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.timelessfinds.Model.Cart;
import com.fdmgroup.timelessfinds.Model.Product;
import com.fdmgroup.timelessfinds.Repository.CartRepository;
import com.fdmgroup.timelessfinds.Repository.ProductRepository;

import jakarta.transaction.Transactional;


@Service
public class CartService {

	private CartRepository cartRepo;
	
	private ProductRepository productRepo;
	
    public CartService(CartRepository cartRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }
    
    public List<Product> getListOfProducts(long cartId){
    	return cartRepo.findProductsInCartById(cartId);
    }
    
    @Transactional
    public void addProductToCart(long cartId, long productId) {
    	Optional<Cart> cartOptional = cartRepo.findById(cartId);
    	Optional<Product> productOptional = productRepo.findById(productId);
    	
    	cartOptional.ifPresent(cart -> cart.addProduct(productOptional.get()));
    }
    
}
