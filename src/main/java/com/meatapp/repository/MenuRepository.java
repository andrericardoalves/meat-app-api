package com.meatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meatapp.model.MenuItem;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Long> {

	public List<MenuItem> findByName(String name);
	
	@Query("SELECT m from MenuItem m WHERE m.restaurantId.id = :restaurantId")
	public List<MenuItem> findMenusById(@Param("restaurantId") Long restaurantId);
	
}
