package com.fdmgroup.timelessfinds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.timelessfinds.model.Product;
import com.fdmgroup.timelessfinds.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository  productRepository;

	@Autowired 
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	public List <Product > findAllProducts() {
		return productRepository.findAll();
	}
}
