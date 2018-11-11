package com.meatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meatapp.model.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long>{

	@Query("SELECT r from Reviews r where r.restaurantId = :restaurantId")
	public List<Reviews> findReviewsByRestaurantId(@Param("restaurantId") Long restaurantId);
	
}
