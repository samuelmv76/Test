package org.cifpAviles.SpringBootCRUD.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Categoria")
public class Categoria {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique =true)
	private String nombre;

	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(Long id, String nombre) {
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
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}

	
	
	
}
