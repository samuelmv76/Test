package Animales;

import java.util.concurrent.Semaphore;

//clase padre
public class Animal{
	
	private String nombre = "Tortuga";
	private int posicion;//siempre 0 al empezar
	private int velocidad;
	protected Semaphore tunel;
	
	
	public Animal(String nombre, int posicion, int velocidad, Semaphore tunel) {
		super();
		this.nombre = nombre;
		this.posicion = 0;
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
