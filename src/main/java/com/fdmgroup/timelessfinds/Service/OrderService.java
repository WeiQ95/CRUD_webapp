package com.fdmgroup.timelessfinds.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.fdmgroup.timelessfinds.Model.Order;
import com.fdmgroup.timelessfinds.Model.Product;
import com.fdmgroup.timelessfinds.Repository.OrderRepository;
import com.fdmgroup.timelessfinds.Repository.ProductRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order getOrderDetail(long orderId) {
        Optional<Order> order = this.orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

    public double getCartAmount(List<Product> cartList) {

        double totalCartAmount = 0f;
        double singleCartAmount = 0f;
        int availableQuantity = 0;

        for (Product item : cartList) {

            long itemId = item.getProductId();
            Optional<Product> product = productRepository.findByProductId(itemId);
            
            if (product.isPresent()) {
                Product productInRepo = product.get();
                
                //if demand greater than qty in stock
                if (item.getQuantity() > productInRepo.getQuantity()) {
                    singleCartAmount = productInRepo.getPrice() * productInRepo.getQuantity();
                    
                    //set quantity to be that of available stock
                    item.setQuantity(productInRepo.getQuantity());
                } 
                else {
                    singleCartAmount = productInRepo.getPrice() * item.getQuantity();
                    availableQuantity = productInRepo.getQuantity() - item.getQuantity();
                }
                totalCartAmount += singleCartAmount;
                productInRepo.setQuantity(availableQuantity);
                //availableQuantity=0;
                //.setProductName(productInRepo.getName());
                //.setAmount(singleCartAmount);
                productRepository.save(productInRepo);
            }
        }
        return totalCartAmount;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}