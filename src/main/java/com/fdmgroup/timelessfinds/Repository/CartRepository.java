package com.fdmgroup.timelessfinds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.timelessfinds.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
}
