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

import com.meatapp.model.MenuItem;
import com.meatapp.service.MenuService;

@RestController
@RequestMapping(value="/menus")
public class MenuRest {

	@Autowired
	private MenuService service;
	
	@RequestMapping(path="/save",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody MenuItem menu){
		MenuItem obj = service.save(menu);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdMenuItem()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(path="/findAll",method=RequestMethod.GET)
	public ResponseEntity<List<MenuItem>>  findAll(){
		List<MenuItem> listMenu = service.findAll();
		return ResponseEntity.ok().body(listMenu);
	}
	
	@RequestMapping(path="/findById/{id}", method=RequestMethod.GET)
	public ResponseEntity<MenuItem> findById(@PathVariable(value="id") long id){
		MenuItem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestParam Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	 @RequestMapping(path="/findByName",  method=RequestMethod.GET)
	 public List<MenuItem> findByName(@RequestParam String name){
		return service.findByName(name);
	}
	
	 @RequestMapping(path="/saveAll",method=RequestMethod.POST)
		public ResponseEntity<Void> saveAll(@RequestBody List<MenuItem> menus){
			List<MenuItem> objList = service.saveAll(menus);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					  .buildAndExpand(objList).toUri();
			return ResponseEntity.created(uri).build();
		}
	 
	 @RequestMapping(path="/findMenusById/{id}",  method=RequestMethod.GET)
	 public ResponseEntity<List<MenuItem>> findMenusById(@PathVariable("id") Long id){
		 List<MenuItem> listMenu = service.findMenusById(id);
		 return ResponseEntity.ok().body(listMenu);
	 }
}
