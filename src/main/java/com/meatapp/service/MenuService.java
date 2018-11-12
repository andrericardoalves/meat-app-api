package com.meatapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatapp.model.MenuItem;
import com.meatapp.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository service;
	
	public MenuItem save(MenuItem menu){
		return service.save(menu);
	}
	
	public List<MenuItem> findAll(){
		return service.findAll();
	}
	
	public MenuItem findById(Long id){
	
	Optional<MenuItem> menu = service.findById(id);
	 
	if(menu.isPresent()){
		 return menu.get();
	}
	
		return null;
	}
	
	public void delete(Long id){
		service.deleteById(id);
	}
	
	public List<MenuItem> findByName(String name){
		return service.findByName(name);
	}
	
	public List<MenuItem> saveAll(List<MenuItem> menus){
		 return service.saveAll(menus);
	}
	
	public List<MenuItem> findMenusById(Long id){
		 return service.findMenusById(id);
	}
	
}
