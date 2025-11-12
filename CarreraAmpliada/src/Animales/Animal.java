package Animales;

import java.util.concurrent.Semaphore;

//clase padre
public class Animal{
	
	private String nombre;
	private int posicion;
	private int velocidad;
	protected Semaphore tunel;
	
	
	public Animal(String nombre, int posicion, int velocidad, Semaphore tunel) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.velocidad = velocidad;
		this.tunel = tunel;
	}
	
	public Semaphore getTunel() {
		return tunel;
	}
	public void setTunel(Semaphore tunel) {
		this.tunel = tunel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
