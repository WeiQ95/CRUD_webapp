package com.fdmgroup.timelessfinds.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fdmgroup.timelessfinds.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Optional<Product>  findById(Long id);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:searchTerm%")
	public List<Product> findProductsByMatchingName(String searchTerm);
    
}
