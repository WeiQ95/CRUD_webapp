package com.fdmgroup.timelessfinds.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.timelessfinds.Model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    
}
