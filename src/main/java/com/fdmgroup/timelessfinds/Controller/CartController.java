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

import com.fdmgroup.timelessfinds.model.jointables.CartProduct;
import com.fdmgroup.timelessfinds.service.CartProductService;
import com.fdmgroup.timelessfinds.service.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller 
@RequestMapping("/")
public class CartController {
	
	private final CartProductService cartProductService;

	@Autowired
	public CartController(ProductService productService, CartProductService cartProductService) {
		super();
		this.cartProductService = cartProductService;
	}
	
    @PostMapping("/productcatalogue/addtocart")
    public String addProductToCart(CartProduct cartItem, HttpSession session) {
    	System.out.println(cartItem.getId());
//    	cartProductService.addProductToCart(1, productID);
    	return "redirect:/catalog";
    }
	
	@GetMapping("/cartpage")
	@ResponseStatus(HttpStatus.OK)
	public String viewCart(Model model) {
//		model.addAttribute("products", );
		return "cart";
	}
}
