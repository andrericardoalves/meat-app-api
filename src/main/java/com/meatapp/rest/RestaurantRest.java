package com.meatapp.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meatapp.model.Restaurant;
import com.meatapp.service.RestaurantService;

@RestController
@RequestMapping(value="/restaurants")
public class RestaurantRest {

	@Autowired
	private RestaurantService service;
	
	@RequestMapping(path="/save",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Restaurant restaurant){
		Restaurant obj = service.save(restaurant);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path="/findAll",method=RequestMethod.GET)
	public ResponseEntity<List<Restaurant>>  findAll(){
		List<Restaurant> listRestaurant = service.findAll();
		return ResponseEntity.ok().body(listRestaurant);
	}
	
	@RequestMapping(path="/findById", method=RequestMethod.GET)
	public ResponseEntity<Restaurant> findById(@RequestParam long id){
		Restaurant obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestParam Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	 @RequestMapping(path="/findByName",  method=RequestMethod.GET)
		public List<Restaurant> findByName(@RequestParam String name){
			return service.findByName(name);
		}
	
	 @RequestMapping(path="/saveAll",method=RequestMethod.POST)
		public ResponseEntity<Void> saveAll(@RequestBody List<Restaurant> restaurants){
			List<Restaurant> objList = service.saveAll(restaurants);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					  .buildAndExpand(objList).toUri();
			return ResponseEntity.created(uri).build();
		}
}
