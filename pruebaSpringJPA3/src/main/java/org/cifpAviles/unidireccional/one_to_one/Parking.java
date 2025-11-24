package org.cifpAviles.unidireccional.one_to_one;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity(name="uni_parking_one_to_one")
@Table(name="uni_parking_one_to_one")
public class Parking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
}