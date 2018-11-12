package com.meatapp.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meatapp.model.Reviews;
import com.meatapp.service.ReviewsService;

@RestController
@RequestMapping(value="/reviews")
public class ReviewsRest {

	@Autowired
	private ReviewsService service;
	
	@RequestMapping(path="/save",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Reviews reviews){
		Reviews obj = service.save(reviews);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path="/reviewsOfRestaurant/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Reviews>>  reviewsOfRestaurant(@PathVariable(value="id")long id){
		List<Reviews> listUsers = service.reviewsOfRestaurant(id);
		return ResponseEntity.ok().body(listUsers);
	}
		
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestParam Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
    @RequestMapping(path="/saveAll",method=RequestMethod.POST)
	public ResponseEntity<Void> saveAll(@RequestBody List<Reviews> reviews){
		List<Reviews> objList = service.saveAll(reviews);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .buildAndExpand(objList).toUri();
		return ResponseEntity.created(uri).build();
	}
   
}
