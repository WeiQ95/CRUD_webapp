package com.fdmgroup.timelessfinds.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fdmgroup.timelessfinds.Model.Product;
import com.fdmgroup.timelessfinds.Model.User;
import com.fdmgroup.timelessfinds.Repository.ProductRepository;


@Service
public class ProductService {

	private ProductRepository productRepo;
	
	@Autowired
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}

	public void addProduct(Product product, User currentUser) throws AccessDeniedException {
		System.out.println(currentUser.getEmail());
		System.out.println("Current user isAdmin: " + currentUser.isAdmin());
		if (!currentUser.isAdmin()) {
		    throw new AccessDeniedException("You do not have permission to add products");
		  }
		product.setCategory(product.getCategory());
		product.setDescription(product.getDescription());
		product.setName(product.getName());
		product.setPrice(product.getPrice());
		product.setQuantity(product.getQuantity());
		productRepo.save(product);
	}

	public void removeProduct(Product product, User currentUser) throws AccessDeniedException {
		if (!currentUser.isAdmin()) {
			throw new AccessDeniedException("You do not have permission to update products");
		}
		productRepo.delete(product);
	}
	
	public void updateProduct(Long id, Product updatedProduct, User currentUser) throws AccessDeniedException {
		if (!currentUser.isAdmin()) {
		    throw new AccessDeniedException("You do not have permission to update products");
		  }
		Optional<Product> optionalProduct = productRepo.findByProductId(id);
		
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setCategory(updatedProduct.getCategory());
			product.setDescription(updatedProduct.getDescription());
			product.setImageUrl(updatedProduct.getImageUrl());
			product.setName(updatedProduct.getName());
			product.setPrice(updatedProduct.getPrice());
			product.setQuantity(updatedProduct.getQuantity());
			productRepo.save(product);
		} else {
			throw new IllegalArgumentException("Product with Id " + id + " not found");
		}
	}
	
	public Product getProductById(Long id) {
		return productRepo.findByProductId(id)
				.orElseThrow();
	}
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	public void deleteProduct(Long id, User currentUser) throws AccessDeniedException {
		if (!currentUser.isAdmin()) {
			throw new AccessDeniedException("You do not have permission to remove products");
		}
		Product product = productRepo.findByProductId(id)
				.orElseThrow();
		productRepo.delete(product);
	}

	public List<Product> findProductsByMatchingName(String searchTerm) {
		return productRepo.findProductsByMatchingName(searchTerm);
	}
}
