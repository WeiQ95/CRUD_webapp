package com.fdmgroup.timelessfinds.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.fdmgroup.timelessfinds.Controller.ProductController;
import com.fdmgroup.timelessfinds.Model.Product;
import com.fdmgroup.timelessfinds.Repository.ProductRepository;
import com.fdmgroup.timelessfinds.Service.CartService;
import com.fdmgroup.timelessfinds.Service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	@Mock Model model;

	@Mock ProductService productService;
	
	@Mock CartService cartService;
	
	ProductController productController;

	@Test
	@DisplayName("verify that search term is passed to findProductsByMatchingName method and resulting list is added as model attribute")
	void goToProductCatalogue() {
		productController = new ProductController(productService, cartService);
		Product apple = new Product();
		apple.setName("apple");
		List<Product> products = new ArrayList<>(List.of(apple));
		when(productService.findProductsByMatchingName("apple")).thenReturn(products);
		
		String actual = productController.goToProductCatalogue(model, "apple");
		
		verify(model).addAttribute("products", products);
		assertEquals("productcatalogue", actual);
	}

}
