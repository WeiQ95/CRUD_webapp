package com.fdmgroup.timelessfinds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fdmgroup.timelessfinds.model.jointables.CartProduct;
import com.fdmgroup.timelessfinds.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/catalog")
	@ResponseStatus(HttpStatus.OK)
	public String getCatalog(Model model) {
		model.addAttribute("products", productService.findAllProducts());
//		model.addAttribute("cartItem", new CartProduct());
		return "catalog";
	}
}