package com.meatapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatapp.model.Restaurant;
import com.meatapp.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository service;
	
	public Restaurant save(Restaurant restaurant){
		return service.save(restaurant);
	}
	
	public List<Restaurant> findAll(){
		return service.findAll();
	}
	
	public Restaurant findById(Long id){
	
	Optional<Restaurant> restaurant = service.findById(id);
	 
	if(restaurant.isPresent()){
		 return restaurant.get();
	}
	
		return null;
	}
	
	public void delete(Long id){
		service.deleteById(id);
	}
	
	public List<Restaurant> findByName(String name){
		return service.findByName(name);
	}
	
	public List<Restaurant> saveAll(List<Restaurant> restaurantes){
		 return service.saveAll(restaurantes);
	}
	
}
