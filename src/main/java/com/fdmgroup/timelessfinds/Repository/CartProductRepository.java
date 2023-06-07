package com.fdmgroup.timelessfinds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.timelessfinds.model.Cart;
import com.fdmgroup.timelessfinds.model.jointables.CartProduct;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

	
}
