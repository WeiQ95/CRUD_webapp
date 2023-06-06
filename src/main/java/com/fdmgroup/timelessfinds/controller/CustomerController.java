package com.fdmgroup.timelessfinds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fdmgroup.timelessfinds.service.ProductService;


@Controller 
@RequestMapping("/")
public class CustomerController {
	
	private final ProductService productService;

	@Autowired
	public CustomerController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/catalog")
	@ResponseStatus(HttpStatus.OK)
	public String getCatalog(Model model) {
		model.addAttribute("products", productService.findAllProducts());
		return "catalog";
	}

	@GetMapping("/cartpage")
	@ResponseStatus(HttpStatus.OK)
	public String viewCart(Model model) {
		model.addAttribute("products", );
		return "cart";
	}
}
