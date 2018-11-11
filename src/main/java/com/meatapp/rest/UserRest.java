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

import com.meatapp.model.User;
import com.meatapp.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserRest {

	@Autowired
	private UserService service;
	
	@RequestMapping(path="/save",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody User user){
		User obj = service.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path="/findAllUsers",method=RequestMethod.GET)
	public ResponseEntity<List<User>>  findAllUsers(){
		List<User> listUsers = service.findAllUsers();
		return ResponseEntity.ok().body(listUsers);
	}
	
	@RequestMapping(path="/findById", method=RequestMethod.GET)
	public ResponseEntity<User> findById(@RequestParam long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestParam Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
    @RequestMapping(path="/findByEmail",  method=RequestMethod.GET)
	public User findByEmail(@RequestParam String email){
		return service.findByEmail(email);
	}
    
    @RequestMapping(path="/saveAll",method=RequestMethod.POST)
	public ResponseEntity<Void> saveAll(@RequestBody List<User> users){
		List<User> objList = service.saveAll(users);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .buildAndExpand(objList).toUri();
		return ResponseEntity.created(uri).build();
	}
}
