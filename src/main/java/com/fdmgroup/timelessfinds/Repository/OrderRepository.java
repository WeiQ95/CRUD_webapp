package com.fdmgroup.timelessfinds.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.timelessfinds.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    
}