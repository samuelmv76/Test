package org.cifpAviles.unidireccional.many_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="uni_empleado_many_to_one")
@Table(name="uni_empleado_many_to_one")
public class Escuela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombreEscuela;
	private String direccion;
	
	
}
