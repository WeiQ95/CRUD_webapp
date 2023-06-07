package com.fdmgroup.timelessfinds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fdmgroup.timelessfinds.model.Product;
import com.fdmgroup.timelessfinds.model.jointables.CartProduct;
import com.fdmgroup.timelessfinds.repository.ProductRepository;
import com.fdmgroup.timelessfinds.service.CartProductService;
import com.fdmgroup.timelessfinds.service.CartService;
import com.fdmgroup.timelessfinds.service.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller 
@RequestMapping("/")
public class CartController {
	
	private final CartProductService cartProductService;
	private final CartService cartService;
	private final ProductService productService;

	@Autowired
	public CartController(CartProductService cartProductService, CartService cartService, ProductService productService) {
		super();
		this.cartProductService = cartProductService;
		this.cartService = cartService;
		this.productService = productService;
	}
	
    @PostMapping("/productcatalogue/addtocart")
    public String addProductToCart(HttpSession session, @RequestParam("productID") long productID) {
    	CartProduct cartItem = new CartProduct();
    	cartItem.setProduct(productService.findById(productID));
    	System.err.println("hi");
    	cartItem.setCart(cartService.findById(1));
    	cartItem.setQuantity(1);
    	System.err.println("bye");
    	cartProductService.addProductToCart(cartItem);
    	System.err.println("adios");
    	return "redirect:/catalog";
    }
	
	@GetMapping("/cartpage")
	@ResponseStatus(HttpStatus.OK)
	public String viewCart(Model model) {
//		model.addAttribute("products", );
		return "cart";
	}
}
