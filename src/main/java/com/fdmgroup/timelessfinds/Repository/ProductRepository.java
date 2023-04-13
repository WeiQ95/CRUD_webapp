package com.fdmgroup.timelessfinds.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.timelessfinds.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Optional<Product>  findByProductId(Long productId);
    
}
