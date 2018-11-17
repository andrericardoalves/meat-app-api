package com.meatapp.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatapp.model.Address;
import com.meatapp.model.OrderItem;
import com.meatapp.model.Orders;
import com.meatapp.model.User;
import com.meatapp.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	public Orders save(Orders order){
		Orders obj = new Orders();
		User user = userService.findById(order.getUser().getIdUser());
		obj.setUser(user);
		Address address = addressService.save(order.getAddress());
		address.setUser(user);
		obj.setAddress(address);
		List<OrderItem> orderItems = orderItemService.save(order.getOrderItems());
		obj.setOrderItems(orderItems);
		return repository.save(obj);
	}
	
	public Orders findById(Long id){
		Optional<Orders> menu = repository.findById(id);
		 
		if(menu.isPresent()){
			 return menu.get();
		}
		
			return null;
	}
	
}
