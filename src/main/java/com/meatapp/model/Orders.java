package com.meatapp.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders implements Serializable {

	
	 /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idOrder;
		 	
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
	 private List<OrderItem> orderItems ;
	 	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name= "user_id")
	 private User user;
	  
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name= "address_id")
	 private Address address;
	
	 
	 
}
