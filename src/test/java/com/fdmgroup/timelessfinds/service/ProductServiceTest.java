package com.fdmgroup.timelessfinds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroup.timelessfinds.Repository.ProductRepository;
import com.fdmgroup.timelessfinds.Service.ProductService;
import com.fdmgroup.timelessfinds.model.Product;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock ProductRepository productRepo;
	
	ProductService productService;
	
	Product apple;
	
	@BeforeEach
	void setup() {
		productService = new ProductService(productRepo);
        Product apple = new Product();
		apple.setName("apple");
	}
	
	@Test
	@DisplayName("search product repo for non-existent product, should return empty list")
	void findProductsByMatchingNameNonExistentProduct() {
		when(productRepo.findProductsByMatchingName("pear")).thenReturn(new ArrayList<>());
		List<Product> actual = productService.findProductsByMatchingName("pear");
        
		assertEquals(new ArrayList<>(), actual);
	}
	
	@Test
	@DisplayName("search product repo for existing product, should return list with single matching product")
	void findProductsByMatchingNameExistingProduct() {
		when(productRepo.findProductsByMatchingName("app")).thenReturn(Arrays.asList(apple));
		
		List<Product> actual = productService.findProductsByMatchingName("app");
		
		assertEquals(Arrays.asList(apple), actual);
	}
	
	@Test
	@DisplayName("search product repo for existing products, should return list with matching products")
	void findProductsByMatchingNameExistingProducts() {
		when(productRepo.findProductsByMatchingName("apple")).thenReturn(Arrays.asList(apple, apple));
		
		List<Product> actual = productService.findProductsByMatchingName("apple");
		
		assertEquals(Arrays.asList(apple, apple), actual);
	}
	
	@Test
	@DisplayName("search product repo for existing products, should return list with matching products")
	void findProductsByMatchingNameExistingProductsWithSpacesInName() {
		when(productRepo.findProductsByMatchingName("apple")).thenReturn(Arrays.asList(apple, apple));
		
		List<Product> actual = productService.findProductsByMatchingName("apple");
		
		assertEquals(Arrays.asList(apple, apple), actual);
	}

}
