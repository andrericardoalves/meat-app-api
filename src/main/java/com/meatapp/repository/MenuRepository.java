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
	
	@Query("SELECT m from MenuItem m WHERE m.idRestaurant.id = :idRestaurant")
	public List<MenuItem> findMenusById(@Param("idRestaurant") Long idRestaurant);
	
}
