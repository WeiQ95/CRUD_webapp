// package com.fdmgroup.timelessfinds;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.ApplicationArguments;
// import org.springframework.boot.ApplicationRunner;
// import org.springframework.stereotype.Component;
// import com.fdmgroup.timelessfinds.Model.*;
// import com.fdmgroup.timelessfinds.Repository.*;

// @Component
// public class DemoData implements ApplicationRunner{
	
// 	@Autowired
// 	CartRepository cartRepository ;
// 	@Autowired
// 	OrderRepository orderRepository ;
// 	@Autowired
// 	ProductRepository productRepository ;
// 	@Autowired
// 	UserRepository userRepository ;
	
// 	@Override
// 	public void run(ApplicationArguments args) throws Exception {
		
// 		User u1 = new User("abcdef@gmail.com", "jon", "jon", true);
// 		User u2 = new User("fabcde", "yangyu", "yangyu", false);
		
// 		Product p1 = new Product("table1", "table", 1.00, "table", 10, "tabletable");
// 		Product p2 = new Product("chair1", "chair", 2.00, "chair", 10, "chairchair");
		
// 		Cart c1 = new Cart();
// 		Cart c2 = new Cart();
		
// 		Order o1 =  new Order(3.00, "jon", "abcdefg", "email", "12345678");
// 		Order o2 =  new Order(2.00, "yangyu", "dressssss", "mailerrrrr", "65432111");
		
// 		c1.addProduct(p1);
// 		c1.addProduct(p2);
// 		c2.addProduct(p2);
		
// 		u1.setCart(c1);
// 		u2.setCart(c2);
		
// 		List<Order> ord1 = u1.getOrders();
// 		ord1.add(o1);
// 		u1.setOrders(ord1);
// 		List<Order> ord2 = u2.getOrders();
// 		ord2.add(o2);
// 		u2.setOrders(ord2);
		
// 		o1.setUser(u1);
// 		o2.setUser(u2);

// 		productRepository.save(p1);
// 		productRepository.save(p2);

// 		cartRepository.save(c1);
// 		cartRepository.save(c2);

// //		userRepository.save(u1);
// //		userRepository.save(u2);
						
// //		orderRepository.save(o1);
// //		orderRepository.save(o2);
// 	}

// }