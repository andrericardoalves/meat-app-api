package com.meatapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meatapp.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	public List<Menu> findByName(String name);
}
