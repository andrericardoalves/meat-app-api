package com.meatapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatapp.model.Menu;
import com.meatapp.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository service;
	
	public Menu save(Menu menu){
		return service.save(menu);
	}
	
	public List<Menu> findAll(){
		return service.findAll();
	}
	
	public Menu findById(Long id){
	
	Optional<Menu> menu = service.findById(id);
	 
	if(menu.isPresent()){
		 return menu.get();
	}
	
		return null;
	}
	
	public void delete(Long id){
		service.deleteById(id);
	}
	
	public List<Menu> findByName(String name){
		return service.findByName(name);
	}
	
	public List<Menu> saveAll(List<Menu> menus){
		 return service.saveAll(menus);
	}
	
}
