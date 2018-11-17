package com.meatapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatapp.model.OrderItem;
import com.meatapp.repository.OrderItemRepository;


@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	public List<OrderItem> save(List<OrderItem> orderItens){
		return repository.saveAll(orderItens);
	}
}
