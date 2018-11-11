package com.meatapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meatapp.model.Reviews;
import com.meatapp.repository.ReviewsRepository;

@Service
public class ReviewsService {

	@Autowired
	private ReviewsRepository repository;
	
	public Reviews save(Reviews reviews){
		return	repository.save(reviews);
	}
	
	public void delete(Long id){
		repository.deleteById(id);
	}
	
	public List<Reviews> saveAll(List<Reviews> reviews){
		 return repository.saveAll(reviews);
	}
	
	public List<Reviews> findReviewsByRestaurantId(Long id){
		 return	repository.findReviewsByRestaurantId(id);
	}
}
