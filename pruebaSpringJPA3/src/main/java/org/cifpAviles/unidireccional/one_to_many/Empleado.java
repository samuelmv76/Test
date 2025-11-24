package org.cifpAviles.unidireccional.one_to_many;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity(name="uni_empleado_one_to_many")
@Table(name="uni_empleado_one_to_many")
public class Empleado {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombreEmpleado;
	private String turnoEmpleado;
}