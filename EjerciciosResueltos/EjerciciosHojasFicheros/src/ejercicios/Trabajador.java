package ejercicios;

import java.io.Serializable;

public class Trabajador implements Serializable{
	
	private String nombre;
	private int edad;
	private int numeroHijos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNumeroHijos() {
		return numeroHijos;
	}
	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}
	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", edad=" + edad + ", numeroHijos=" + numeroHijos + "]";
	}
	public Trabajador(String nombre, int edad, int numeroHijos) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.numeroHijos = numeroHijos;
	}
	
	public Trabajador() {
		super();
		
	}
	
	

}
