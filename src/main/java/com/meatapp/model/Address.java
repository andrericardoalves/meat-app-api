package com.meatapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Address implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idAddress;
	 private String street;
     private Integer number;
     private String optionalAddress;
     private String city;
     private String state;
     private String zipCode;
     
     @JoinColumn(name= "idUser")
     @ManyToOne(cascade = CascadeType.ALL)
     private User user;
}
