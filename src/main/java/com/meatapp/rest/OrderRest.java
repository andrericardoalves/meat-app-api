package com.meatapp.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.meatapp.model.Orders;
import com.meatapp.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderRest {

	@Autowired
	private OrderService service;
	
	@RequestMapping(path="/save",method=RequestMethod.POST)
	public ResponseEntity<Orders> save(@RequestBody Orders order){
		Orders obj = service.save(order);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(path="/findById/{id}", method=RequestMethod.GET)
	public ResponseEntity<Orders> findById(@PathVariable(value="id") Long id){
		Orders obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
