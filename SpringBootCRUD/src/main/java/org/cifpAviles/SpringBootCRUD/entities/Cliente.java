package org.cifpAviles.SpringBootCRUD.entities;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="Cliente")
public class Cliente {
	
	@Column(nullable=false,unique =true)
	private String nombre;

	@Column(nullable=false,unique =true)
	private String email;

	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String email, List<Pedido> pedidos) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.pedidos = pedidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", email=" + email + "]";
	}
	
	
}
