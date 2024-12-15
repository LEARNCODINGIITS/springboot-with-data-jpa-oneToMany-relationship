package com.iits.main.command;
 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.iits.main.entity.Customer;
import com.iits.main.entity.Orders;
import com.iits.main.repository.CustomerRepository;
import com.iits.main.repository.OrderItemRepository;
import com.iits.main.repository.OrderRepository;


@Component
public class CommandLineTest implements CommandLineRunner {
 
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
    @Autowired
    OrderItemRepository orderItemRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		  
		
		storeData();
		fetchDataBasedOnCustomer();
		fetchDataBasedOnOrders();
	}

	

	public void storeData() {
	    Customer c = new Customer();
	    c.setAddress("vkb");
	    c.setName("raju");
	    c.setEmail("abc@gmail.com");
	    
	    Orders o1 = new Orders();
	    o1.setOrderDate("15-12-2024");
	    o1.setAmount(2000);
	    o1.setCustomer(c); // Set customer reference in orders
	    
	    Orders o2 = new Orders();
	    o2.setOrderDate("15-12-2024");
	    o2.setAmount(3000);
	    o2.setCustomer(c); // Set customer reference in orders

	    c.setOrders(List.of(o1, o2)); // Add orders to the customer
	    this.customerRepository.save(c);
	}
	public void fetchDataBasedOnCustomer() {
	    Customer customer = this.customerRepository.findById(1L).orElse(null);
	    if (customer != null) {
	        System.out.println("Customer Details: " + customer);
	        System.out.println("Orders: " + customer.getOrders());
	    } else {
	        System.out.println("Customer not found!");
	    }
	}
	public void fetchDataBasedOnOrders() {
	    List<Orders> list = this.orderRepository.findAll();
	    if (list != null && !list.isEmpty()) {
	        for (Orders order : list) {
	            System.out.println(order);
	            System.out.println(order.getCustomer());
	        }
	    } else {
	        System.out.println("No orders found!");
	    }
	}


}
