package com.fdmgroup.timelessfinds.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdmgroup.timelessfinds.Model.Order;
import com.fdmgroup.timelessfinds.Model.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
	public Optional<Order>  findById(Long id);
}