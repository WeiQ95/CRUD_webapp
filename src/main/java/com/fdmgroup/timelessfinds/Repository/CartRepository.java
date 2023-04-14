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
    
    @Query(value = "SELECT * FROM Cart c WHERE c.order_id = ?1", nativeQuery = true) 
    Cart findCartByOrderId(Long order_id);
    
    @Query(value = "SELECT product_id FROM cart_product p where p.cartId = ?1", nativeQuery = true) 
    List<Product> findProductsInCartByID(Long cartId);
}
