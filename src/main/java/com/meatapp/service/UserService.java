package com.meatapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatapp.model.User;
import com.meatapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User save(User user){
		return repository.save(user); 
	}
	
	public List<User> findAllUsers(){
	 return	repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> user = repository.findById(id);
		
		if(user.isPresent()){
			return user.get();
		}
		
		return null; 
	}
	
	public void delete(Long id){
		repository.deleteById(id);
	}
	
	public User findByEmail(String email){
		return repository.findByEmail(email);
	}
	
	public List<User> saveAll(List<User> users){
		return repository.saveAll(users);
	}
	
	public User login(User user){
		return repository.login(user.getEmail(),user.getPassword());
	}
}
