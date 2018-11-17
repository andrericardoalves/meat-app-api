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
	private MenuRepository repository;
	
	public MenuItem save(MenuItem menu){
		return repository.save(menu);
	}
	
	public List<MenuItem> findAll(){
		return repository.findAll();
	}
	
	public MenuItem findById(Long id){
	
	Optional<MenuItem> menu = repository.findById(id);
	 
	if(menu.isPresent()){
		 return menu.get();
	}
	
		return null;
	}
	
	public void delete(Long id){
		repository.deleteById(id);
	}
	
	public List<MenuItem> findByName(String name){
		return repository.findByName(name);
	}
	
	public List<MenuItem> saveAll(List<MenuItem> menus){
		 return repository.saveAll(menus);
	}
	
	public List<MenuItem> findMenusById(Long id){
		 return repository.findMenusById(id);
	}
	
}
