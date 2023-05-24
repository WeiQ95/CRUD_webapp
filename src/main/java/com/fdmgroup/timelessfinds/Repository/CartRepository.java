package com.fdmgroup.timelessfinds.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fdmgroup.timelessfinds.Model.Cart;
import com.fdmgroup.timelessfinds.Model.Product;


@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    
    @Query(value = "SELECT fk_product_id FROM cart_product p where p.fk_cart_id = ?1", nativeQuery = true) 
    List<Product> findProductsInCartById(Long cartId);
}
