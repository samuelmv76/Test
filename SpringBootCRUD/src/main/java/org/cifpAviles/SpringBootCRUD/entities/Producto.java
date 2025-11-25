package org.cifpAviles.SpringBootCRUD.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private double precio;
	
	//relacion Muchos a Uno con Categoria
	//un producto pertenece a UNA categoría por eso se crea categoria en la tabla tambien
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false) 
    private Categoria categoria;

	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, double precio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + "]";
	}

}