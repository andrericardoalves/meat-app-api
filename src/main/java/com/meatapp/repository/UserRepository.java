package com.meatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meatapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.email = :email and u.password = :password")
	public User login(@Param("email") String email,@Param("password") String password);
	
}
