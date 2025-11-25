package org.cifpAviles.SpringBootCRUD.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Pedido")
public class Pedido {

	@Id //clave Primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Date fecha;
	
	
	//relacion Muchos a Uno con Cliente
		//muchos pedidos pueden pertenecer a un solo cliente.
		@ManyToOne
		@JoinColumn(name = "cliente_id", nullable = false) 
		private Cliente cliente;
		
		
		//relacion Muchos a Muchos con Producto
		//un pedido tiene muchos productos, y un producto esta en muchos pedidos.
		@ManyToMany
		@JoinTable(
			name = "pedido_producto", // Nombre de la tabla intermedia
			joinColumns = @JoinColumn(name = "pedido_id"), // FK de esta entidad
			inverseJoinColumns = @JoinColumn(name = "producto_id") // FK de la entidad Producto
		)
		private List<Producto> productos;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedido(Date fecha) {
		super();
		this.fecha = fecha;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + "]";
	}

	
	
	
}
