package org.cifpAviles.pruebaSpring.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique =true)
	private String nombre;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + "]";
	}

	
}
