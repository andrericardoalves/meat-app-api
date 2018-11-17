package com.meatapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Restaurant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRestaurant;
	private String name;
	private String category;
	private String deliveryEstimate;
	private String rating;
	private String imagePath;
	private String about;
	private String  hours;
	
	@OneToMany(mappedBy = "idRestaurant" , cascade = CascadeType.ALL )
	@JsonIgnore
	private List<MenuItem> menus;
}
